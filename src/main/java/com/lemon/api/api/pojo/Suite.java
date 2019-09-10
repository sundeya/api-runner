package com.lemon.api.api.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
public class Suite implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 集合id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 集合名字
     */
    private String name;

    /**
     * 集合描述
     */
    private String description;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    private List<CaseMenuVO> caseMenuVOs;

    public Suite() {
    }

    public List<CaseMenuVO> getCaseMenuVOs() {
        return caseMenuVOs;
    }

    public void setCaseMenuVOs(List<CaseMenuVO> caseMenuVOs) {
        this.caseMenuVOs = caseMenuVOs;
    }

    public Integer getId() {
        return id;
    }

    public Suite setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getProjectId() {
        return projectId;
    }

    public Suite setProjectId(Integer projectId) {
        this.projectId = projectId;
        return this;
    }
    public String getName() {
        return name;
    }

    public Suite setName(String name) {
        this.name = name;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public Suite setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getCreateUser() {
        return createUser;
    }

    public Suite setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }
    public String getCreateTime() {
        return createTime;
    }

    public Suite setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "Suite{" +
            "id=" + id +
            ", projectId=" + projectId +
            ", name=" + name +
            ", description=" + description +
            ", createUser=" + createUser +
            ", createTime=" + createTime +
        "}";
    }
}
