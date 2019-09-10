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
public class Cases implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用例id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联套件id
     */
    private Integer suiteId;

    /**
     * 用例名
     */
    private String name;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    public Integer getId() {
        return id;
    }

    public Cases setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getSuiteId() {
        return suiteId;
    }

    public Cases setSuiteId(Integer suiteId) {
        this.suiteId = suiteId;
        return this;
    }
    public String getName() {
        return name;
    }

    public Cases setName(String name) {
        this.name = name;
        return this;
    }
    public String getCreateUser() {
        return createUser;
    }

    public Cases setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }
    public String getCreateTime() {
        return createTime;
    }

    public Cases setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "Cases{" +
            "id=" + id +
            ", suiteId=" + suiteId +
            ", name=" + name +
            ", createUser=" + createUser +
            ", createTime=" + createTime +
        "}";
    }
}
