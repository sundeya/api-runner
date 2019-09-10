package com.lemon.api.api.dao;

import com.lemon.api.api.pojo.ApiAndclassifi;
import com.lemon.api.api.pojo.ApiClassification;

import java.util.List;

public interface ApiCLassificationMapper {
    public void addApi(ApiClassification apiClassification) throws Exception;
    public List<ApiClassification> findAllApiClassifi(String projectId) throws Exception;
    List<ApiClassification> findAllApiClassByClassifiId(String apiClassifiId) throws Exception;
}
