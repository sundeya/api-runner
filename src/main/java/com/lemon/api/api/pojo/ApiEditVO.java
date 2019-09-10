package com.lemon.api.api.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiEditVO {
    private String apiId;
    private String apiName;
    private String apiMethod;
    private String apiClassifiId;
    private String apiUrl;
    private List<ApiRequestParam> requestParams =new ArrayList<ApiRequestParam>();
    private List<ApiRequestParam> bodyParams=new ArrayList<ApiRequestParam>();
    private List<ApiRequestParam> queryParams=new ArrayList<ApiRequestParam>();
    private List<ApiRequestParam> headerParams=new ArrayList<ApiRequestParam>();
    private List<ApiRequestParam> bodyRawParams=new ArrayList<ApiRequestParam>();

}
