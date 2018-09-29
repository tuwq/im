package root.mq.consumer;

import java.util.Map;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class TestConsumer {

	@RabbitListener(bindings=@QueueBinding(
		value = @Queue(value="queue-tim",durable="true"), 
		exchange = @Exchange(value="exchange-tim", durable="true",type="topic",ignoreDeclarationExceptions="true"),
		key = "tim.#"
		)
	)
	@RabbitHandler
	public void onMessage(Message<String> message, Channel channel) throws Exception{
		System.out.println("into..............................");
		System.err.println("--------------------------------------");
		System.err.println("消费端Payload: " + message.getPayload());
		Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
		// ACK
		channel.basicAck(deliveryTag, false);
	}
}

