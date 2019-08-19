package com.lemon.api.api;

import com.lemon.api.api.dao.UserMapper;
import com.lemon.api.api.pojo.Api;
import com.lemon.api.api.pojo.User;
import com.lemon.api.api.service.IApiService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApiRunnerApplication.class})
public class UserTest {
    @Autowired
    private IApiService apiService;
    @Test
    public void test() throws Exception {
        User user=new User("小的","123456","2019-08-03 22:22:00");
        Api api=new Api();
        api.setApiClassifiId(1);
        api.setMethod("get");
        api.setUrl("/111/mmm");
        apiService.save(api);

    }
}
