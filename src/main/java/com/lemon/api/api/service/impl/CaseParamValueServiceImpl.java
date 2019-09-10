package com.lemon.api.api.service.impl;

import com.lemon.api.api.pojo.CaseParamValue;
import com.lemon.api.api.dao.CaseParamValueMapper;
import com.lemon.api.api.service.ICaseParamValueService;
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
public class CaseParamValueServiceImpl extends ServiceImpl<CaseParamValueMapper, CaseParamValue> implements ICaseParamValueService {
    @Autowired
    private CaseParamValueMapper caseParamValueMapper;
    @Override
    public void updateCaseParam(List<CaseParamValue> caseParamValues) throws Exception {
        caseParamValueMapper.updateCaseParam(caseParamValues);
    }

    @Override
    public void removeByApiRequestParamId(List<Integer> removedApiRequestParamIds) throws Exception {
        caseParamValueMapper.removeByApiRequestParamId(removedApiRequestParamIds);
    }

    @Override
    public List<Integer> findCaseIdByApiId(String apiId) throws Exception {
        return caseParamValueMapper.findCaseIdByApiId(apiId);
    }
}
