package com.lemon.api.api.dao;

import com.lemon.api.api.pojo.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nickjiang
 * @since 2019-08-14
 */
public interface ApiMapper extends BaseMapper<Api> {
    public List<ShowApiList> finaAllApis(String projectId) throws Exception;
    public List<ShowApiList> finaAllApisByClassifi(String apiClassificationId) throws Exception;
    public MenuVO findMenuVOs(String apiId)throws Exception;
    public ApiPreview findApiPreview(String apiId) throws Exception;
    public void editSave(ApiEditVO apiEditVO) throws Exception;
    public void updateBasicInfo(ApiEditVO apiEditVO) throws Exception;
    public ApiEditVO findApiEdit(String apiId) throws Exception;
    ApiRunVO findApiRunVO(String apiId) throws Exception;
}
