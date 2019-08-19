package com.lemon.api.api.service.impl;

import com.lemon.api.api.dao.ProjectDao;
import com.lemon.api.api.pojo.ApiClassification;
import com.lemon.api.api.pojo.Project;
import com.lemon.api.api.service.ApiClassificationService;
import com.lemon.api.api.service.ProjectService;
import com.lemon.api.api.untils.DateUntils;
import com.lemon.api.api.untils.LoginUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ApiClassificationService apiClassificationService;
    @Override
    public void add(Project project) throws Exception {
        projectDao.add(project);
        ApiClassification apiClassification=new ApiClassification();
        apiClassification.setProjectId(project.getId());
        apiClassification.setName("公共分类");
        apiClassification.setDescription("公共分类");
        apiClassification.setCreateUser(LoginUntils.getCrentUserId());
        apiClassification.setCreateTime(DateUntils.formatYmdhms(new Date()));
        apiClassificationService.addApi(apiClassification);
    }
    @Override
    public List<Project> findall() throws Exception {
        return projectDao.findall();
    }
}
