package com.lemon.api.api.service;

import com.lemon.api.api.pojo.Api;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.api.api.pojo.ApiPreview;
import com.lemon.api.api.pojo.MenuVO;
import com.lemon.api.api.pojo.ShowApiList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nickjiang
 * @since 2019-08-14
 */
public interface IApiService extends IService<Api> {

    public List<ShowApiList> finaAllApis(String projectId) throws Exception;

    List<ShowApiList> finaAllApisByClassifi(String apiClassificationId) throws Exception;

    public MenuVO findMenuVOs(String apiId)throws Exception;

    public ApiPreview findApiPreview(String apiId) throws Exception;
}
