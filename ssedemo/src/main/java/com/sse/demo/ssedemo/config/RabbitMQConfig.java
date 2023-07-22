package com.sse.demo.ssedemo.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

//	@Bean(name = "rabbitListenerContainerFactory")
//	public RabbitListenerContainerFactory<SimpleMessageListenerContainer> prefetchTenRabbitListenerContainerFactory(
//			ConnectionFactory rabbitConnectionFactory) {
//		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//		factory.setConnectionFactory(rabbitConnectionFactory);
//		factory.setPrefetchCount(10);
//		return factory;
//	}

//	@Bean(name = "rabbitTemplateForEvents")
//	public RabbitTemplate getRabbitTemplateForEvents(ConnectionFactory connectionFactory) {
//		final RabbitTemplate template = new RabbitTemplate(connectionFactory);
//		template.setMessageConverter(jsonMessageConverter());
//		template.setExchange(""));
//		template.setRoutingKey(""));
//		template.setConnectionFactory(connectionFactory);
//		return template;
//	}

	@Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
