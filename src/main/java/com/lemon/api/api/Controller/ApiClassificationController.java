package com.lemon.api.api.Controller;

import com.lemon.api.api.pojo.ApiAndclassifi;
import com.lemon.api.api.pojo.ApiClassification;
import com.lemon.api.api.pojo.Result;
import com.lemon.api.api.service.ApiClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apiClass")
public class ApiClassificationController {
    @Autowired
    private ApiClassificationService apiClassificationService;
    @RequestMapping("/addClassification")
    public Result addClassification(ApiClassification apiClassification){
        Result result=null;
        try {
            //apiClassification
            apiClassificationService.addApi(apiClassification);
            System.out.println("11111111");
            result=new Result("1","获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("0","服务异常");
        }

        return result;

    }
    @RequestMapping("/getAllClassification")
    public Result getAllClassification(String projectId){
        Result result=null;
        List<ApiClassification> apiClassifications=new ArrayList<ApiClassification>();
        try {
            //apiClassification
            apiClassifications=apiClassificationService.findAllApiClassifi(projectId);
            result=new Result("1",apiClassifications,"获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result("0","服务异常");
        }

        return result;

    }
}
