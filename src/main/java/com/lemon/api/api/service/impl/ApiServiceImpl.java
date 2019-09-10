package com.lemon.api.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.api.pojo.*;
import com.lemon.api.api.dao.ApiMapper;
import com.lemon.api.api.service.IApiRequestParamService;
import com.lemon.api.api.service.IApiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.api.api.service.ICaseParamValueService;
import org.apache.http.Header;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nickjiang
 * @since 2019-08-14
 */
@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements IApiService {
    @Autowired
    private ApiMapper apiMapper;
    @Autowired
    private IApiRequestParamService iApiRequestParamService;
    @Autowired
    private ICaseParamValueService iCaseParamValueService;
    @Override
    public List<ShowApiList> finaAllApis(String projectId) throws Exception {
        return apiMapper.finaAllApis(projectId);
    }

    @Override
    public List<ShowApiList> finaAllApisByClassifi(String apiClassificationId) throws Exception {
        return apiMapper.finaAllApisByClassifi(apiClassificationId);
    }

    @Override
    public MenuVO findMenuVOs(String apiId) throws Exception {
        return apiMapper.findMenuVOs(apiId);


    }

    @Override
    public ApiPreview findApiPreview(String apiId) throws Exception {
       ApiPreview apiPreview=apiMapper.findApiPreview(apiId);
        if(apiPreview==null){
            return null;
        }else {
            for(ApiRequestParam apiRequestParam : apiPreview.getRequestParams()){
                if((apiRequestParam.getType()+"").equals("1")){
                    apiPreview.getQueryParams().add(apiRequestParam);
                }else if((apiRequestParam.getType()+"").equals("2")){
                    apiPreview.getBodyParams().add(apiRequestParam);
                }else if((apiRequestParam.getType()+"").equals("3")){
                    apiPreview.getHeaderParams().add(apiRequestParam);
                }else if((apiRequestParam.getType()+"").equals("4")){
                    apiPreview.getBodyRawParams().add(apiRequestParam);
                }
            }
        }
        return apiPreview;
    }

    @Override
    public void editSave(ApiEditVO apiEditVO) throws Exception {
        apiMapper.updateBasicInfo(apiEditVO);
        //页面参数获取
        List<ApiRequestParam> apiRequestParams=new ArrayList<ApiRequestParam>();

        apiRequestParams.addAll(apiEditVO.getQueryParams());
        apiRequestParams.addAll(apiEditVO.getHeaderParams());
        apiRequestParams.addAll(apiEditVO.getBodyRawParams());
        if(apiEditVO.getBodyRawParams().size()>0){
            apiRequestParams.addAll(apiEditVO.getBodyRawParams());

        }else {
            apiRequestParams.addAll(apiEditVO.getBodyParams());

        }
        //数据库参数获取
        List<ApiRequestParam> dbApiRequestParams=  apiMapper.findApiEdit(apiEditVO.getApiId()).getRequestParams();
        List<Integer> dbApiRequestParamIds=new ArrayList<Integer>();
        for(ApiRequestParam apiRequestParam:dbApiRequestParams){
            dbApiRequestParamIds.add(apiRequestParam.getId());
        }
        List<ApiRequestParam> addApiRequestParams=new ArrayList<ApiRequestParam>();
        List<ApiRequestParam> editApiRequestParams=new ArrayList<ApiRequestParam>();
        for(ApiRequestParam apiRequestParam:apiRequestParams){
            if(apiRequestParam.getId()==null){
                addApiRequestParams.add(apiRequestParam);
            }else {
                editApiRequestParams.add(apiRequestParam);
                dbApiRequestParamIds.remove(apiRequestParam.getId());
            }
        }
        //将要删除的参数id
        List<Integer> removedApiRequestParamIds=dbApiRequestParamIds;
        if(removedApiRequestParamIds.size()>0){
            iApiRequestParamService.removeByIds(removedApiRequestParamIds);
            iCaseParamValueService.removeByApiRequestParamId(removedApiRequestParamIds);
        }

        //执行新增
        if(addApiRequestParams.size()>0){
            iApiRequestParamService.saveBatch(addApiRequestParams);
            List<Integer> caseIds=iCaseParamValueService.findCaseIdByApiId(apiEditVO.getApiId());
            List<CaseParamValue> caseParamValues=new ArrayList<CaseParamValue>();
            for(Integer caseId:caseIds){
                for(ApiRequestParam apiRequestParam:addApiRequestParams){
                    CaseParamValue caseParamValue=new CaseParamValue();
                    caseParamValue.setCaseId(caseId);
                    caseParamValue.setApiRequestParamId(apiRequestParam.getId());
                    caseParamValues.add(caseParamValue);
                }
            }
            iCaseParamValueService.saveBatch(caseParamValues);
        }

        //更新
        if(editApiRequestParams.size()>0){
            iApiRequestParamService.updateBatchById(editApiRequestParams);
        }



    }

    @Override
    public ApiEditVO findApiEdit(String apiId) throws Exception {
        ApiEditVO apiEditVO=apiMapper.findApiEdit(apiId);
        if(!apiEditVO.getRequestParams().isEmpty()){
            for(ApiRequestParam apiRequestParam : apiEditVO.getRequestParams()){
                if((apiRequestParam.getType()+"").equals("1")){
                    apiEditVO.getQueryParams().add(apiRequestParam);
                }else if((apiRequestParam.getType()+"").equals("2")){
                    apiEditVO.getBodyParams().add(apiRequestParam);
                }else if((apiRequestParam.getType()+"").equals("3")){
                    apiEditVO.getHeaderParams().add(apiRequestParam);
                }else if((apiRequestParam.getType()+"").equals("4")){
                    apiEditVO.getBodyRawParams().add(apiRequestParam);
                }

            }
        }
        return apiEditVO;
    }

    @Override
    public ApiRunVO findApiRunVO(String apiId) throws Exception {
        ApiRunVO apiRunVO= apiMapper.findApiRunVO(apiId);
        if(!apiRunVO.getRequestParams().isEmpty()){
            for(ApiRequestParam apiRequestParam : apiRunVO.getRequestParams()){
                if((apiRequestParam.getType()+"").equals("1")){
                    apiRunVO.getQueryParams().add(apiRequestParam);
                }else if((apiRequestParam.getType()+"").equals("2")){
                    apiRunVO.getBodyParams().add(apiRequestParam);
                }else if((apiRequestParam.getType()+"").equals("3")){
                    apiRunVO.getHeaderParams().add(apiRequestParam);
                }
                else if((apiRequestParam.getType()+"").equals("4")){
                    apiRunVO.getBodyRawParams().add(apiRequestParam);
                }
            }
        }
        return apiRunVO;
    }

    @Override
    public ApiOnlineResponse run(ApiRunVO apiRunVO) throws Exception {
        String method=apiRunVO.getMethod();
        String host=apiRunVO.getHost();
        String url=apiRunVO.getUrl();
        List<BasicNameValuePair> params=new ArrayList<>();
        ApiOnlineResponse apiOnlineResponse=new ApiOnlineResponse();
        CloseableHttpResponse response=null;
        String name=null;
        String value=null;
        if(apiRunVO.getHeaderParams().size()>0){
            for(ApiRequestParam apiRequestParam:apiRunVO.getHeaderParams()){
                 name=apiRequestParam.getName();
                 value=apiRequestParam.getValue();
            }
        }
        if(method.toUpperCase().equals("GET")){

            for(ApiRequestParam apiRequestParam:apiRunVO.getQueryParams()){

                BasicNameValuePair basicNameValuePair=new BasicNameValuePair(apiRequestParam.getName(),apiRequestParam.getValue());
                params.add(basicNameValuePair);


            }
            url=host+url+params;
            HttpGet httpGet=new HttpGet(url);
            httpGet.addHeader( new BasicHeader(name,value));
            CloseableHttpClient httpClient= HttpClients.createDefault();
             response=httpClient.execute(httpGet);

        }else if(method.toUpperCase().equals("POST")){
            if(apiRunVO.getBodyRawParams().size()>0){
                for(ApiRequestParam apiRequestParam:apiRunVO.getBodyRawParams()){

                    BasicNameValuePair basicNameValuePair=new BasicNameValuePair(apiRequestParam.getName(),apiRequestParam.getValue());
                    params.add(basicNameValuePair);
                }
            }else {
                for(ApiRequestParam apiRequestParam:apiRunVO.getBodyParams()){

                    BasicNameValuePair basicNameValuePair=new BasicNameValuePair(apiRequestParam.getName(),apiRequestParam.getValue());
                    params.add(basicNameValuePair);
                }
            }


            url=host+url;
            HttpPost post=new HttpPost(url);
            post.addHeader( new BasicHeader(name,value));
            post.setEntity(new UrlEncodedFormEntity(params));
            CloseableHttpClient httpClient= HttpClients.createDefault();
            response=httpClient.execute(post);

        }
        Header[] headers=response.getAllHeaders();
        Map<String,Object> headerString=new HashMap<String, Object>();
        for(Header header:headers){
            String name1=header.getName();
            String value1=header.getValue();
            headerString.put(name1,value1);
        }
        String header=JSONObject.toJSONString(headerString,true);
        String result= EntityUtils.toString(response.getEntity());

        HashMap<String,Object> resultJsonMap=JSONObject.parseObject(result,HashMap.class);
        String resultJsonString=JSONObject.toJSONString(resultJsonMap,true);
        apiOnlineResponse.setResponseData(resultJsonString);
        apiOnlineResponse.setResponseheader(header);
        return apiOnlineResponse;
    }
}
