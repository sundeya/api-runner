package com.lemon.api.api.dao;

import com.lemon.api.api.pojo.CaseParamValue;
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
public interface CaseParamValueMapper extends BaseMapper<CaseParamValue> {
    void updateCaseParam(List<CaseParamValue> caseParamValues) throws Exception;
    public void removeByApiRequestParamId(List<Integer> removedApiRequestParamIds) throws Exception;
    List<Integer> findCaseIdByApiId(String apiId) throws Exception;
}
