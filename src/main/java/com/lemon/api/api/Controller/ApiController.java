package com.lemon.api.api.Controller;


import com.lemon.api.api.dao.ApiMapper;
import com.lemon.api.api.pojo.Api;
import com.lemon.api.api.pojo.ApiPreview;
import com.lemon.api.api.pojo.Result;
import com.lemon.api.api.pojo.ShowApiList;
import com.lemon.api.api.service.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
        modelAndView.addObject("apiId",apiId);
        modelAndView.setViewName("apiEdit");
        return modelAndView;
    }
    @RequestMapping("/toApiRun")
    public ModelAndView toApiRun(String apiId){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("apiId",apiId);
        modelAndView.setViewName("apiRun");
        return modelAndView;
    }
}
