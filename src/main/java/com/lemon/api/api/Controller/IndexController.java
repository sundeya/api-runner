package com.lemon.api.api.Controller;

import com.lemon.api.api.pojo.ApiAndclassifi;
import com.lemon.api.api.pojo.ApiClassification;
import com.lemon.api.api.pojo.MenuVO;
import com.lemon.api.api.pojo.Result;
import com.lemon.api.api.service.ApiClassificationService;
import com.lemon.api.api.service.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private ApiClassificationService apiClassificationService;
    @Autowired
    private IApiService iApiService;
    @RequestMapping("/toindex")
    public ModelAndView modelAndView(String projectId){
        ModelAndView modelAndView=new ModelAndView();
        List<ApiClassification> apiClassifications=new ArrayList<ApiClassification>();
        try {
            apiClassifications=apiClassificationService.findAllApiClassifi(projectId);


        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("projectId",projectId);
        modelAndView.addObject("apiClassifications",apiClassifications);
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
