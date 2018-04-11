package tk.baseaccept.pass.web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.baseaccept.pass.api.TestService;

/*********************************************************************
 * @Author: Administrator extends BaseAccpet 
 * @Date: 2018/4/10 0010 下午 5:22 
 * @Package: tk.baseaccept.pass.web.Controller
 * @ClassInfo
 **********************************************************************/
@RestController
public class TestController {

    @Reference
    private TestService testService;

    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("==========" +  (testService == null) + testService.SayHello("你好 啊，dubbo吗？"));
        return "Hello: " + name;
    }

}
