package com.lemon.api.api.service;

import com.lemon.api.api.pojo.*;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nickjiang
 * @since 2019-09-01
 */
public interface ICasesService extends IService<Cases> {

    void addCaseToSuite(Cases cases, ApiRunVO apiRunVO) throws Exception;

    CaseEdit findCaseEdit(String caseId) throws Exception;

    void updateCase(CaseEdit caseEdit) throws Exception;

    CaseOnlineResponse run(CaseEdit caseEdit) throws  Exception;

    MenuVO findSuiteSelectedMenu(String caseId) throws Exception;
}
