package com.lemon.api.api.service.impl;

import com.lemon.api.api.dao.CaseParamValueMapper;
import com.lemon.api.api.pojo.*;
import com.lemon.api.api.dao.CasesMapper;
import com.lemon.api.api.service.IApiService;
import com.lemon.api.api.service.ICaseParamValueService;
import com.lemon.api.api.service.ICasesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
@Service
public class CasesServiceImpl extends ServiceImpl<CasesMapper, Cases> implements ICasesService {
    @Autowired
    private  CasesMapper casesMapper;
    @Autowired
    private ICaseParamValueService caseParamValueService;
    @Autowired
    private IApiService apiService;
    @Override
    public void addCaseToSuite(Cases cases, ApiRunVO apiRunVO) throws Exception {
        casesMapper.insert(cases);
        List<ApiRequestParam> apiRequestParams=new ArrayList<>();

        apiRequestParams.addAll(apiRunVO.getBodyRawParams());
        apiRequestParams.addAll(apiRunVO.getBodyParams());
        apiRequestParams.addAll(apiRunVO.getQueryParams());
        apiRequestParams.addAll(apiRunVO.getHeaderParams());
        List<CaseParamValue> caseParamValues=new ArrayList<>();
        for(ApiRequestParam apiRequestParam:apiRequestParams){
            CaseParamValue caseParamValue=new CaseParamValue();
            System.out.println(apiRequestParam.getId()+"  "+apiRequestParam.getValue());
            caseParamValue.setCaseId(cases.getId());
            caseParamValue.setApiRequestParamId(apiRequestParam.getId());
            caseParamValue.setApiRequestParamValue(apiRequestParam.getValue());
            caseParamValues.add(caseParamValue);
        }
        caseParamValueService.saveBatch(caseParamValues);

    }

    @Override
    public CaseEdit findCaseEdit(String caseId) throws Exception {
        CaseEdit  caseEdit=casesMapper.findCaseEdit(caseId);
        if(caseEdit!=null){
            for(ApiRequestParam apiRequestParam:caseEdit.getRequestParams()){
                if("1".equals(apiRequestParam.getType()+"")){
                    caseEdit.getQueryParams().add(apiRequestParam);
                 }else if("2".equals(apiRequestParam.getType()+"")){
                    caseEdit.getBodyParams().add(apiRequestParam);
                }else if("3".equals(apiRequestParam.getType()+"")){
                    caseEdit.getHeaderParams().add(apiRequestParam);
                }else if("4".equals(apiRequestParam.getType()+"")){
                    caseEdit.getBodyRawParams().add(apiRequestParam);
                }
            }
        }
        return  caseEdit;
    }

    @Override
    public void updateCase(CaseEdit caseEdit) throws Exception {
        Cases cases=new Cases();
        cases.setId(Integer.valueOf(caseEdit.getId()));
        cases.setName(caseEdit.getCaseName());
        casesMapper.updateById(cases);
        List<ApiRequestParam> apiRequestParams=new ArrayList<>();
        List<CaseParamValue> caseParamValues=new ArrayList<>();
        apiRequestParams.addAll(caseEdit.getBodyParams());
        apiRequestParams.addAll(caseEdit.getBodyRawParams());
        apiRequestParams.addAll(caseEdit.getHeaderParams());
        apiRequestParams.addAll(caseEdit.getQueryParams());
        for(ApiRequestParam apiRequestParam:apiRequestParams){
            CaseParamValue caseParamValue=new CaseParamValue();
            caseParamValue.setCaseId(Integer.valueOf(caseEdit.getId()));
            caseParamValue.setApiRequestParamId(apiRequestParam.getId());
            caseParamValue.setApiRequestParamValue(apiRequestParam.getValue());
            caseParamValues.add(caseParamValue);
        }
        caseParamValueService.updateCaseParam(caseParamValues);



    }

    @Override
    public CaseOnlineResponse run(CaseEdit caseEdit) throws Exception {
        ApiRunVO apiRunVO=new ApiRunVO();
        BeanUtils.copyProperties(caseEdit,apiRunVO);
        ApiOnlineResponse apiOnlineResponse=apiService.run(apiRunVO);
        CaseOnlineResponse caseOnlineResponse=new CaseOnlineResponse();
        BeanUtils.copyProperties(apiOnlineResponse,caseOnlineResponse);
        return  caseOnlineResponse;
    }
}
