package tk.baseaccept.pass.chat.controller;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;
import tk.baseaccept.pass.chat.bean.ResponseBean;
import tk.baseaccept.pass.chat.domain.UserInfo;
import tk.baseaccept.pass.chat.exception.UnauthorizedException;
import tk.baseaccept.pass.chat.service.UserService;
import tk.baseaccept.pass.chat.util.EncryptUtils;
import tk.baseaccept.pass.chat.util.JWTUtil;

import java.util.List;

/*********************************************************************
 * @Author: Administrator extends BaseAccpet 
 * @Date: 2018/4/12 0012 下午 3:37 
 * @Package: tk.baseaccept.pass.chat.controller
 * @ClassInfo
 **********************************************************************/
@Controller
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @RequiresAuthentication
    public ModelAndView test(ModelAndView modelAndView){
        List<UserInfo> userInfos= userService.findUsers();
        modelAndView.setViewName("test");
        modelAndView.addObject("userInfos",userInfos);
        modelAndView.addObject("jsValue","jsValue");
        return modelAndView;
    }
    private static final Logger LOGGER = LogManager.getLogger(TestController.class);
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                              @RequestParam("password") String password,ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();//获取当前用户对象
        //生成令牌(传入用户输入的账号和密码)
        UsernamePasswordToken token=new UsernamePasswordToken(username, EncryptUtils.MD5(password));
        //认证登录
        try {
            //这里会加载自定义的realm
            subject.login(token);//把令牌放到login里面进行查询,如果查询账号和密码时候匹配,如果匹配就把user对象获取出来,失败就抛异常

            Session session = SecurityUtils.getSubject().getSession();
            UserInfo user= (UserInfo) session.getAttribute("user");;//获取登录成功的用户对象(以前是直接去service里面查)
            modelAndView.addObject("user", user);
            return "index";
        } catch (Exception e) {
            //认证登录失败抛出异常
            return "login";
        }
    }

    @RequestMapping("/article")
    public ModelAndView article(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("guest");
        }
        return modelAndView;
    }

    @RequestMapping("/require_auth")
    @RequiresAuthentication
    public ResponseBean requireAuth() {
        return new ResponseBean(200, "You are authenticated", null);
    }

    @RequestMapping("/require_role")
    @RequiresRoles("admin")
    public ResponseBean requireRole() {
        return new ResponseBean(200, "You are visiting require_role", null);
    }

    @RequestMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public ModelAndView requirePermission(ModelAndView modelAndView) {
        modelAndView.setViewName("msg");
        modelAndView.addObject("msg","You are visiting permission require edit,view");
        return modelAndView;
    }

    @RequestMapping("/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseBean unauthorized() {
        return new ResponseBean(401, "Unauthorized", null);
    }
}
