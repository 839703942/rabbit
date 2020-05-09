package com.rabbitmqclent.clent.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConfig {

//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
//        container.setMessageConverter(new Jackson2JsonMessageConverter());
//        // 默认采用下面的这种转换器
//        // container.setMessageConverter(new SimpleMessageConverter());
//        return container;
//    }
}
