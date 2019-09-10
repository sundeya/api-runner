package com.lemon.api.api.Controller;


import com.lemon.api.api.pojo.CaseApi;
import com.lemon.api.api.pojo.Result;
import com.lemon.api.api.pojo.Suite;
import com.lemon.api.api.service.ISuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
@RestController
@RequestMapping("/suite")
public class SuiteController {
    @Autowired
    private ISuiteService iSuiteService;
    @RequestMapping("/add")
    public Result add(Suite suite){
        Result result=null;
        try{
            iSuiteService.save(suite);
            result=new Result("1","成功");
        }catch (Exception e){
            result=new Result("0","异常");
        }

        return result;
    }
    @RequestMapping("/toCaseList")
    public ModelAndView toCaseList(String projectId,String suiteId){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("projectId",projectId);
        modelAndView.setViewName("caseList");
        try {
            List<CaseApi> caseLists=iSuiteService.findCaseList(suiteId);
            modelAndView.addObject("caseLists",caseLists);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
