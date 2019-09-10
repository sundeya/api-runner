package com.lemon.api.api.dao;

import com.lemon.api.api.pojo.CaseApi;
import com.lemon.api.api.pojo.Suite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
public interface SuiteMapper extends BaseMapper<Suite> {
    List<Suite> findSuiteByProject(String apiId) throws Exception;
    List<Suite> findSuitsWithCase(String projectId) throws Exception;
    public List<CaseApi> findCaseList(String suiteId) throws Exception;
}
