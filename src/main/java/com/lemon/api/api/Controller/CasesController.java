package com.lemon.api.api.Controller;


import com.lemon.api.api.pojo.*;
import com.lemon.api.api.service.ICasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
@RestController
@RequestMapping("/cases")
public class CasesController {
    @Autowired
    private ICasesService iCasesService;
    @RequestMapping("/addCaseToSuite")
    public Result addCaseToSuite(Cases cases, ApiRunVO apiRunVO){
        Result result=null;
        try {
            iCasesService.addCaseToSuite(cases,apiRunVO);
            result=new Result("1","添加集合成功");
        }catch (Exception e){
            result=new Result("0","异常");
        }

        return result;
    }
    @RequestMapping("/toCaseEdit")
    public ModelAndView toCaselist(String caseId){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("caseEdit");
        CaseEdit caseEdit= null;
        try {
            caseEdit = iCasesService.findCaseEdit(caseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("caseEdit",caseEdit);
        return modelAndView;
    }
    @RequestMapping("/updateCase")
    public Result updateCase(CaseEdit caseEdit){
        Result result=null;
        try {
            iCasesService.updateCase(caseEdit);
            result=new Result("1","更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("0","服务器异常");
        }

        return result;
    }
    @RequestMapping("/run")
    public Result run(CaseEdit caseEdit){
        Result result=null;
        try {
            CaseOnlineResponse caseOnlineResponse=iCasesService.run(caseEdit);
            result=new Result("1",caseOnlineResponse,"运行成功");
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("0","服务器异常");
        }

        return result;
    }
    @RequestMapping("/findSuiteSelectedMenu")
    public Result findSuiteSelectedMenu( String caseId){
        Result result =null;
        MenuVO menuVO= null;
        try {
            menuVO = iCasesService.findSuiteSelectedMenu(caseId);
            result=new Result("1",menuVO,"查询一二级集合菜单成功");
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("0","服务器异常");
        }



        return result;
    }

}
