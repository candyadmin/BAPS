package tk.baseaccept.pass.chat.provider;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.baseaccept.pass.chat.bean.QueueList;
import tk.baseaccept.pass.chat.bean.ResponseBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*********************************************************************
 * @Author: Administrator extends BaseAccpet 
 * @Date: 2018/4/16 0016 上午 11:11 
 * @Package: tk.baseaccept.pass.chat.provider
 * @ClassInfo
 **********************************************************************/
@Controller
public class TestActiMqController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @RequestMapping(value = "/")
    public String home() throws IOException {
        Map<String, String> msg = new HashMap<>();
        msg.put("key", "hi,activeMQ");
        jmsMessagingTemplate.convertAndSend(QueueList.BUSINESS1, JSON.toJSONString(msg));
        return "hello springboot";
    }

    @RequestMapping(value = "/2")
    public String home2() throws IOException {
        Map<String, String> msg = new HashMap<>();
        msg.put("key", "##hi,activeMQ2");
        jmsMessagingTemplate.convertAndSend(QueueList.BUSINESS2, JSON.toJSONString(msg));
        return "hello springboot";
    }
}
