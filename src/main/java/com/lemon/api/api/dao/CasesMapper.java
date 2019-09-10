package com.lemon.api.api.dao;

import com.lemon.api.api.pojo.ApiRunVO;
import com.lemon.api.api.pojo.CaseEdit;
import com.lemon.api.api.pojo.Cases;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
public interface CasesMapper extends BaseMapper<Cases> {
    void addCaseToSuite(Cases cases, ApiRunVO apiRunVO) throws Exception;
    CaseEdit findCaseEdit(String caseId) throws Exception;
}
