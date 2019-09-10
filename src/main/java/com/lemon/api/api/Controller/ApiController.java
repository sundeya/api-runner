package com.lemon.api.api.Controller;


import com.lemon.api.api.dao.ApiMapper;
import com.lemon.api.api.pojo.*;
import com.lemon.api.api.service.ApiClassificationService;
import com.lemon.api.api.service.IApiRequestParamService;
import com.lemon.api.api.service.IApiService;
import com.lemon.api.api.service.ISuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nickjiang
 * @since 2019-08-14
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private IApiService iApiService;
    @Autowired
    private IApiRequestParamService iApiRequestParamService;
    @Autowired
    private ApiClassificationService apiClassificationService;
    @Autowired
    private ISuiteService iSuiteService;
    @RequestMapping("/toApilist")
    public ModelAndView toList(String projectId,String apiClassificationId){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("projectId",projectId);
        modelAndView.addObject("apiClassificationId",apiClassificationId);
        modelAndView.setViewName("apiList");
        return modelAndView;
    }
    @RequestMapping("/add")
    public Result addApi(Api api){
        Result result=null;
        try
        {
            iApiService.save(api);
            result=new Result("1","添加成功");
        } catch (Exception e){
            result=new Result("0","添加失败");
        }

        return result;
    }
    @RequestMapping("/showAllApis")
    public Result showAllApis(String projectId){
        Result result=null;
        List<ShowApiList> showApiList=new ArrayList<ShowApiList>();
        try
        {
            showApiList=iApiService.finaAllApis(projectId);
            //iApiService.lambdaQuery();
            result=new Result("1",showApiList,"添加成功");
        } catch (Exception e){
            result=new Result("0","添加失败");
        }

        return result;
    }
    @RequestMapping("/showAllApisByClassifi")
    public Result showAllApisByClassifi(String apiClassificationId){
        Result result=null;
        List<ShowApiList> showApiList=new ArrayList<ShowApiList>();
        try
        {
            showApiList=iApiService.finaAllApisByClassifi(apiClassificationId);
            //iApiService.lambdaQuery();
            result=new Result("1",showApiList,"添加成功");
        } catch (Exception e){
            result=new Result("0","添加失败");
        }

        return result;
    }
    @RequestMapping("/toApiView")
    public ModelAndView toApiView(String apiId){
        ModelAndView modelAndView=new ModelAndView();
        try {
            ApiPreview apiPreview=iApiService.findApiPreview(apiId);
            modelAndView.addObject("apiPreview",apiPreview);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("apiId",apiId);
        modelAndView.setViewName("apiView");
        return modelAndView;
    }
    @RequestMapping("/toApiEdit")
    public ModelAndView toApiEdit(String apiId){
        ModelAndView modelAndView=new ModelAndView();
        try {
            ApiEditVO apiEditVO=iApiService.findApiEdit(apiId);
            List<ApiClassification> apiClassifications=apiClassificationService.findAllApiClassByClassifiId(apiEditVO.getApiClassifiId());
            modelAndView.addObject("apiEditVO",apiEditVO);
            modelAndView.addObject("apiClassifications",apiClassifications);

        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("apiId",apiId);
        modelAndView.setViewName("apiEdit");
        return modelAndView;
    }
    @RequestMapping("/toApiRun")
    public ModelAndView toApiRun(String apiId){
        ModelAndView modelAndView=new ModelAndView();
        try {
            ApiRunVO apiRunVO=iApiService.findApiRunVO(apiId);
            modelAndView.addObject("apiRunVO",apiRunVO);
           List<Suite> suites= iSuiteService.findSuiteByProject(apiId);
           modelAndView.addObject("suites",suites);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("apiId",apiId);
        modelAndView.setViewName("apiRun");
        return modelAndView;
    }
    @RequestMapping("/editSave")
    public Result editSave(ApiEditVO apiEditVO){
        Result result=null;
        ApiEditVO apiEditVO1=new ApiEditVO();
        try {
            iApiService.editSave(apiEditVO);
            result=new Result("1","更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("0","服务器异常");
        }
        return  result;
    }
    @RequestMapping("/deleteApiRequestParam")
    public Result deleteApiRequestParam(String paramId){
        Result result=null;
        try {
            Map<String,Object> map=new HashMap<>();
            map.put("id",paramId);
            iApiRequestParamService.removeByMap(map);
            result=new Result("1","删除成功");


        }catch (Exception e){
            result=new Result("0","服务器异常");
        }
        return  result;
    }
    @RequestMapping("/run")
    public Result run(ApiRunVO apiRunVO){
        Result result=null;
        try {
            ApiOnlineResponse apiOnlineResponse=iApiService.run(apiRunVO);
            result=new Result("1",apiOnlineResponse,"运行成功");
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("1","服务器异常");
        }
        return result;
    }

}
