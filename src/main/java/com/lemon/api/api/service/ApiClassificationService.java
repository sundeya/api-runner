package com.lemon.api.api.service;

import com.lemon.api.api.pojo.ApiAndclassifi;
import com.lemon.api.api.pojo.ApiClassification;

import java.util.List;

public interface ApiClassificationService {

    public void addApi(ApiClassification apiClassification) throws Exception;

    public List<ApiClassification> findAllApiClassifi(String projectId) throws Exception;
}
