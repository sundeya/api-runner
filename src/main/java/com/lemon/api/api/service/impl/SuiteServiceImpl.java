package com.lemon.api.api.service.impl;

import com.lemon.api.api.pojo.CaseApi;
import com.lemon.api.api.pojo.Suite;
import com.lemon.api.api.dao.SuiteMapper;
import com.lemon.api.api.service.ISuiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
@Service
public class SuiteServiceImpl extends ServiceImpl<SuiteMapper, Suite> implements ISuiteService {
    @Autowired
    private SuiteMapper suiteMapper;
    @Override
    public List<Suite> findSuiteByProject(String apiId) throws Exception {

        return suiteMapper.findSuiteByProject(apiId);
    }

    @Override
    public List<Suite> findSuitsWithCase(String projectId) throws Exception {

        return suiteMapper.findSuitsWithCase(projectId);
    }

    @Override
    public List<CaseApi> findCaseList(String suiteId) throws Exception {
        return suiteMapper.findCaseList(suiteId);
    }
}
