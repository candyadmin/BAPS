package tk.baseaccept.pass.chat.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import tk.baseaccept.pass.chat.bean.ResponseBean;
import tk.baseaccept.pass.chat.domain.UserInfo;
import tk.baseaccept.pass.chat.exception.UnauthorizedException;
import tk.baseaccept.pass.chat.service.UserService;
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
    public ModelAndView test(ModelAndView modelAndView){
        List<UserInfo> userInfos= userService.findUsers();
        modelAndView.setViewName("test");
        modelAndView.addObject("userInfos",userInfos);
        modelAndView.addObject("jsValue","jsValue");
        return modelAndView;
    }
    private static final Logger LOGGER = LogManager.getLogger(TestController.class);
    @RequestMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        UserInfo userBean = userService.getUserByName(username);
        if (userBean.getPassword().equals(password)) {
            return new ResponseBean(200, "Login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }

    @RequestMapping("/article")
    public ResponseBean article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ResponseBean(200, "You are already logged in", null);
        } else {
            return new ResponseBean(200, "You are guest", null);
        }
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
    public ResponseBean requirePermission() {
        return new ResponseBean(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping("/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseBean unauthorized() {
        return new ResponseBean(401, "Unauthorized", null);
    }
}
