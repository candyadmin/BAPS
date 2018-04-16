package tk.baseaccept.pass.chat.shiro;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.baseaccept.pass.chat.domain.UserInfo;
import tk.baseaccept.pass.chat.service.UserService;
import tk.baseaccept.pass.chat.util.JWTUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);
    @Autowired
    private UserService userService;
    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserInfo user = userService.getUserByName((String) principals.getPrimaryPrincipal());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getRole());
        Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
        simpleAuthorizationInfo.addStringPermissions(permission);
        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        // 解密获得username，用于和数据库进行对比
        UsernamePasswordToken needGetAuthUserPW= ((UsernamePasswordToken) auth);
        UserInfo userBean = userService.getUserByName(needGetAuthUserPW.getUsername().toString());
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!String.valueOf(((UsernamePasswordToken) auth).getPassword()).equals(userBean.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", userBean);
        return new SimpleAuthenticationInfo(userBean.getName(), userBean.getPassword(), getName());
    }
}
