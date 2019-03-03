package com.qworldr.customer.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qworldr.customer.bean.UserEntitiy;
import com.qworldr.customer.mapper.UserEntitiyMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wujiazhen
 * @date 2019/2/24
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserEntitiyMapper userEntitiyMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserEntitiy primaryPrincipal = (UserEntitiy) principalCollection.getPrimaryPrincipal();
        info.addStringPermission(primaryPrincipal.getRole());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken principal = (UsernamePasswordToken) authenticationToken;
        String username=principal.getUsername();
        char[] password = principal.getPassword();

        List<UserEntitiy> userEntitiys = userEntitiyMapper.selectList(new QueryWrapper<UserEntitiy>().eq("phone",username));
        if(userEntitiys==null || userEntitiys.size()==0){
            return null;
        }else {
            UserEntitiy userEntitiy = userEntitiys.get(0);
            return new SimpleAuthenticationInfo(userEntitiy,userEntitiy.getPassword(),this.getName());
        }
    }
}
