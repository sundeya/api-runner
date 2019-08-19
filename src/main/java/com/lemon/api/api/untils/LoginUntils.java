package com.lemon.api.api.untils;

import com.lemon.api.api.pojo.User;
import org.apache.shiro.SecurityUtils;

public class LoginUntils {
    public static String getCrentUserId(){
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        return user.getId();
    }
}
