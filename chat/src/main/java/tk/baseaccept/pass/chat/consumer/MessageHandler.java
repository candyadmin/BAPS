package tk.baseaccept.pass.chat.consumer;

import com.alibaba.fastjson.JSON;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tk.baseaccept.pass.chat.bean.QueueList;
import tk.baseaccept.pass.chat.bean.ResponseBean;

import java.util.Map;

@Component
public class MessageHandler {

	@JmsListener(destination = QueueList.BUSINESS2)
	public void receiveQueueObj(String txtMsg) {
		// 消息内容转为具体对象，数据类型更明晰
		Map map = JSON.parseObject(txtMsg, Map.class);// 推荐该转换方案
		System.out.println("##activemq.queue#" + JSON.toJSONString(map));
	}

	@JmsListener(destination = QueueList.BUSINESS1)
	public void receiveQueue(String txtMsg) {
		// 消息内容转为Map<String,Object>
		Map<String, Object> map = JSON.parseObject(txtMsg);
		System.out.println("##activemq.queue#" + map);
	}

}
