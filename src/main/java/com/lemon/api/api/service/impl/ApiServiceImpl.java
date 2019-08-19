package com.lemon.api.api.service.impl;

import com.lemon.api.api.pojo.Api;
import com.lemon.api.api.dao.ApiMapper;
import com.lemon.api.api.pojo.ApiPreview;
import com.lemon.api.api.pojo.MenuVO;
import com.lemon.api.api.pojo.ShowApiList;
import com.lemon.api.api.service.IApiService;
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
 * @since 2019-08-14
 */
@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements IApiService {
    @Autowired
    private ApiMapper apiMapper;
    @Override
    public List<ShowApiList> finaAllApis(String projectId) throws Exception {
        return apiMapper.finaAllApis(projectId);
    }

    @Override
    public List<ShowApiList> finaAllApisByClassifi(String apiClassificationId) throws Exception {
        return apiMapper.finaAllApisByClassifi(apiClassificationId);
    }

    @Override
    public MenuVO findMenuVOs(String apiId) throws Exception {
        return apiMapper.findMenuVOs(apiId);
    }

    @Override
    public ApiPreview findApiPreview(String apiId) throws Exception {
        return apiMapper.findApiPreview(apiId);
    }
}
