package com.lemon.api.api.service;

import com.lemon.api.api.pojo.*;
import com.baomidou.mybatisplus.extension.service.IService;

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

     public void editSave(ApiEditVO apiEditVO) throws Exception;

    public ApiEditVO findApiEdit(String apiId) throws Exception;

    ApiRunVO findApiRunVO(String apiId) throws Exception;

    ApiOnlineResponse run(ApiRunVO apiRunVO) throws Exception;
}
