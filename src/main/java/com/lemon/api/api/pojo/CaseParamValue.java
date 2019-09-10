package com.lemon.api.api.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
public class CaseParamValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联用例id
     */
    private Integer caseId;

    /**
     * 关联接口参数id
     */
    private Integer apiRequestParamId;

    /**
     * 参数值
     */
    private String apiRequestParamValue;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    public Integer getId() {
        return id;
    }

    public CaseParamValue setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getCaseId() {
        return caseId;
    }

    public CaseParamValue setCaseId(Integer caseId) {
        this.caseId = caseId;
        return this;
    }
    public Integer getApiRequestParamId() {
        return apiRequestParamId;
    }

    public CaseParamValue setApiRequestParamId(Integer apiRequestParamId) {
        this.apiRequestParamId = apiRequestParamId;
        return this;
    }
    public String getApiRequestParamValue() {
        return apiRequestParamValue;
    }

    public CaseParamValue setApiRequestParamValue(String apiRequestParamValue) {
        this.apiRequestParamValue = apiRequestParamValue;
        return this;
    }
    public String getCreateUser() {
        return createUser;
    }

    public CaseParamValue setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }
    public String getCreateTime() {
        return createTime;
    }

    public CaseParamValue setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "CaseParamValue{" +
            "id=" + id +
            ", caseId=" + caseId +
            ", apiRequestParamId=" + apiRequestParamId +
            ", apiRequestParamValue=" + apiRequestParamValue +
            ", createUser=" + createUser +
            ", createTime=" + createTime +
        "}";
    }
}
