package com.lemon.api.api.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author nickjiang
 * @since 2019-08-21
 */
@Data
public class ApiRequestParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联接口id
     */
    private Integer apiId;

    /**
     * 参数字段名称
     */
    private String name;

    /**
     * 参数类型
     */
    private String paramType;

    /**
     * 参数类型（1，query;2,body;3,header）
     */
    private Integer type;

    /**
     * 示例
     */
    private String exampleData;
    @TableField(exist = false)
    private String value;

    /**
     * 描述
     */
    private String description;

    public Integer getId() {
        return id;
    }

    public ApiRequestParam setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getApiId() {
        return apiId;
    }

    public ApiRequestParam setApiId(Integer apiId) {
        this.apiId = apiId;
        return this;
    }
    public String getName() {
        return name;
    }

    public ApiRequestParam setName(String name) {
        this.name = name;
        return this;
    }
    public String getParamType() {
        return paramType;
    }

    public ApiRequestParam setParamType(String paramType) {
        this.paramType = paramType;
        return this;
    }
    public Integer getType() {
        return type;
    }

    public ApiRequestParam setType(Integer type) {
        this.type = type;
        return this;
    }
    public String getExampleData() {
        return exampleData;
    }

    public ApiRequestParam setExampleData(String exampleData) {
        this.exampleData = exampleData;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public ApiRequestParam setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "ApiRequestParam{" +
            "id=" + id +
            ", apiId=" + apiId +
            ", name=" + name +
            ", paramType=" + paramType +
            ", type=" + type +
            ", exampleData=" + exampleData +
            ", description=" + description +
        "}";
    }
}
