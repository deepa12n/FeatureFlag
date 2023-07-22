package com.sse.demo.ssedemo.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SSEListener {

	@RabbitListener(queues="${ffaas.rabbitmq.queue}",messageConverter="jsonMessageConverter")
	public void onMessage(Message message) {
		
	}
}
