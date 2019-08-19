package com.lemon.api.api.dao;

import com.lemon.api.api.pojo.Project;

import java.util.List;

public interface ProjectDao {
    public void add(Project project) throws Exception;
    public List<Project> findall() throws Exception;
}
