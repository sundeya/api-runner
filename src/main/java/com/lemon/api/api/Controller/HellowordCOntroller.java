package com.lemon.api.api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v",method = RequestMethod.POST)
public class HellowordCOntroller {
    @GetMapping("/v1")
    public Object hello(){
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("name","sss");
        return  result;
    }
    @GetMapping("/v2")
    public Object hello1(){
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("name","ddd");
        return  result;
    }


}
