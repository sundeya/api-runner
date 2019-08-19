package com.lemon.api.api.pojo;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class ApiClassification extends  BasePojo{
    private String projectId;
    private String name;
    private String description;
    private List<ApiAndclassifi> apiAndclassifis;


}
