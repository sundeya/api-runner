package com.lemon.api.api.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ApiRunVO {
    private String Id;
    private String method;
    private String host;
    private String url;
    private List<ApiRequestParam> requestParams =new ArrayList<ApiRequestParam>();
    private List<ApiRequestParam> bodyParams=new ArrayList<ApiRequestParam>();
    private List<ApiRequestParam> queryParams=new ArrayList<ApiRequestParam>();
    private List<ApiRequestParam> headerParams=new ArrayList<ApiRequestParam>();
    private List<ApiRequestParam> bodyRawParams=new ArrayList<ApiRequestParam>();
}
