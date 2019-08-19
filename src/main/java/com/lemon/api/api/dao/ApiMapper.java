package com.lemon.api.api.dao;

import com.lemon.api.api.pojo.Api;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.api.api.pojo.ApiPreview;
import com.lemon.api.api.pojo.MenuVO;
import com.lemon.api.api.pojo.ShowApiList;

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
}
