package com.lemon.api.api.service;

import com.lemon.api.api.pojo.CaseParamValue;
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
public interface ICaseParamValueService extends IService<CaseParamValue> {

    void updateCaseParam(List<CaseParamValue> caseParamValues) throws Exception;

    void removeByApiRequestParamId(List<Integer> removedApiRequestParamIds) throws Exception;

    List<Integer> findCaseIdByApiId(String apiId) throws Exception;
}
