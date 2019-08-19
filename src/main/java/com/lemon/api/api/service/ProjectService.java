package com.lemon.api.api.service;

import com.lemon.api.api.pojo.Project;

import java.util.List;

public interface ProjectService {
    public void add(Project project) throws Exception;

    public List<Project> findall() throws Exception;
}
