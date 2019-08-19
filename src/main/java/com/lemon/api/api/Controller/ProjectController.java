package com.lemon.api.api.Controller;

import com.lemon.api.api.pojo.Project;
import com.lemon.api.api.pojo.Result;
import com.lemon.api.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @RequestMapping("/tolist")
    private ModelAndView tolist(){
        ModelAndView modelAndView=new ModelAndView();
        List<Project> projects=new ArrayList<>();
        try {
            projects=projectService.findall();
            System.out.println(projects.isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("projects",projects);
        modelAndView.setViewName("projectList");
        return modelAndView;
    }
    @RequestMapping("/add")
    private Result add(Project project){
        Result result=null;
        try {
            projectService.add(project);
            result=new Result("1","添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("0","服异常务器");
        }
        return result;
    }
}
