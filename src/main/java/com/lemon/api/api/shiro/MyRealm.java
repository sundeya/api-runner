package com.lemon.api.api.shiro;

import com.lemon.api.api.pojo.User;
import com.lemon.api.api.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=authenticationToken.getPrincipal().toString();
        User user=new User();
        user.setUsername(username);
        try {
            List<User> userdbs= userService.find(user) ;
            for(User dbuser:userdbs){
                if(dbuser==null){
                    return null;
                }else {
                    SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(dbuser,dbuser.getPassword(),getName());
                    return  simpleAuthenticationInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
