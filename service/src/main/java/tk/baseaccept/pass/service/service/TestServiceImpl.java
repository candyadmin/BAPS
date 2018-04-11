package tk.baseaccept.pass.service.service;

import com.alibaba.dubbo.config.annotation.Service;
import tk.baseaccept.pass.api.TestService;

import javax.ws.rs.Path;

/*********************************************************************
 * @Author: Administrator extends BaseAccpet
 * @Date: 2018/4/10 0010 下午 4:47
 * @Package: tk.baseaccept.pass.service.service
 * @ClassInfo
 **********************************************************************/
@Service(protocol = { "dubbo" })
@Path("testService")
public class TestServiceImpl  implements TestService {
    @Override
    public String SayHello(String name) {
        return "你好";
    }
}



