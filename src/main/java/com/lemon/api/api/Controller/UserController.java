package com.lemon.api.api.Controller;

import com.lemon.api.api.pojo.Result;
import com.lemon.api.api.pojo.User;
import com.lemon.api.api.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/toregister")
    private ModelAndView toregister(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @RequestMapping("/register")
    private Result register(User user){
        Result result=null;
        try {
            userService.add(user);
            result =new Result("1","注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            result =new Result("1","服务器异常");
        }


        return result;

    }
    @RequestMapping("/find")
    private Result checkrepeat(User user){

        Result result=null;
        try {
            List<User> dbusers = userService.find(user);
            System.out.println(dbusers.isEmpty());
            if(dbusers.isEmpty()){
                result = new Result("1", "无人使用此账号");
            }else {
                for (User dbuser:dbusers){
                System.out.println(dbuser+" 1111111");
                    if(dbuser!=null){
                        result =new Result("0","此账号被占用,请联系管理员");

                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("0","服务器异常，请联系管理员");
        }


        return result;

    }
    @RequestMapping("/tologin")
    private ModelAndView tologin(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/login")
    private Result login(User user){
        Result result=null;
        try {
            UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
            SecurityUtils.getSubject().login(token);
             result=new Result("1","登录成功");
        }catch (Exception e){
             result=new Result("0","登录异常");
        }
        return result;
    }
    @RequestMapping("/tolist")
    private ModelAndView tolist(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("projectList");
        return modelAndView;
    }




}
