package com.lemon.api.api.service.impl;

import com.lemon.api.api.dao.ApiCLassificationMapper;
import com.lemon.api.api.pojo.ApiAndclassifi;
import com.lemon.api.api.pojo.ApiClassification;
import com.lemon.api.api.service.ApiClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApiClassificationServiceImpl implements ApiClassificationService {
    @Autowired
    public ApiCLassificationMapper apiCLassificationMapper;
    @Override
    public void addApi(ApiClassification apiClassification) throws Exception {

        apiCLassificationMapper.addApi(apiClassification);
    }

    @Override
    public List<ApiClassification> findAllApiClassifi(String projectId) throws Exception {

        return  apiCLassificationMapper.findAllApiClassifi(projectId);
    }
}
