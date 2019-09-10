package com.lemon.api.api.service;

import com.lemon.api.api.pojo.CaseApi;
import com.lemon.api.api.pojo.Suite;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
public interface ISuiteService extends IService<Suite> {

    List<Suite> findSuiteByProject(String apiId) throws Exception;

    List<Suite> findSuitsWithCase(String projectId) throws Exception;

    List<CaseApi> findCaseList(String suiteId) throws Exception;
}
