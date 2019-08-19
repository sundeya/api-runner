package com.lemon.api.api.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author nickjiang
 * @since 2019-08-14
 */
public class Api implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 接口所属分类id
     */
    private Integer apiClassifiId;

    /**
     * 接口名
     */
    private String name;

    /**
     * 接口方法
     */
    private String method;

    /**
     * 接口路径
     */
    private String url;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public Api setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getApiClassifiId() {
        return apiClassifiId;
    }

    public Api setApiClassifiId(Integer apiClassifiId) {
        this.apiClassifiId = apiClassifiId;
        return this;
    }
    public String getName() {
        return name;
    }

    public Api setName(String name) {
        this.name = name;
        return this;
    }
    public String getMethod() {
        return method;
    }

    public Api setMethod(String method) {
        this.method = method;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public Api setUrl(String url) {
        this.url = url;
        return this;
    }
    public Integer getCreateUser() {
        return createUser;
    }

    public Api setCreateUser(Integer createUser) {
        this.createUser = createUser;
        return this;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Api setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "Api{" +
            "id=" + id +
            ", apiClassifiId=" + apiClassifiId +
            ", name=" + name +
            ", method=" + method +
            ", url=" + url +
            ", createUser=" + createUser +
            ", createTime=" + createTime +
        "}";
    }
}
