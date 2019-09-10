package com.lemon.api.api.Controller;

import com.lemon.api.api.pojo.*;
import com.lemon.api.api.service.ApiClassificationService;
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

@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private ApiClassificationService apiClassificationService;
    @Autowired
    private IApiService iApiService;
    @Autowired
    private ISuiteService suiteService;
    @RequestMapping("/toindex")
    public ModelAndView modelAndView(String projectId,String tab){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("tab",tab);
        List<ApiClassification> apiClassifications=new ArrayList<ApiClassification>();
        if (tab.equals("1")){
            try {
                apiClassifications=apiClassificationService.findAllApiClassifi(projectId);
                modelAndView.addObject("apiClassifications",apiClassifications);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if("2".equals(tab)){
            List<Suite> suites= null;
            try {
                suites =suiteService.findSuitsWithCase(projectId);
                modelAndView.addObject("suites",suites);
                for(Suite suite:suites){
                    if(suite.getName().equals("公共测试集")){
                        modelAndView.addObject("suiteId",suite.getId());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        modelAndView.addObject("projectId",projectId);

        modelAndView.setViewName("index");
        return  modelAndView;
    }
    @RequestMapping("/findApiSelectedMenu")
    public Result findApiSelectedMenu(String apiId){
        Result result=null;
        try {
            MenuVO menuVO= iApiService.findMenuVOs(apiId);
            result =new Result("1",menuVO,"获取数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            result =new Result("1","服务异常器");
        }
        return  result;
    }
}
