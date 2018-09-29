package root.mq.producer;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import root.mqbean.TestModel;
import root.util.JsonUtils;


@Component
public class TestProducer {

	@Resource
	private RabbitTemplate rabbitTemplate = new RabbitTemplate();  
	
	//回调函数: confirm确认
	final ConfirmCallback confirmCallback = new ConfirmCallback() {
		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			System.out.println(correlationData);
			System.out.println(ack);
			System.out.println("confrim.....................................");
		}
	};
	
	//回调函数: return返回
	final ReturnCallback returnCallback = new ReturnCallback() {
		@Override
		public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText,
				String exchange, String routingKey) {
			System.out.println(message);
			System.out.println("return......................................");
		}
	};
	
	
	public void TestModelsend(TestModel model, Map<String, Object> properties) {
		MessageHeaders mhs = new MessageHeaders(properties);
		Message<String> msg = MessageBuilder.createMessage(JsonUtils.objectToJson(model), mhs);
		rabbitTemplate.setConfirmCallback(confirmCallback);
		rabbitTemplate.setReturnCallback(returnCallback);
		//id + 时间戳 全局唯一 
		CorrelationData correlationData = new CorrelationData(model.getMessageId());
		rabbitTemplate.convertAndSend("exchange-tim", "tim.hello", msg, correlationData);
	}
	
}
