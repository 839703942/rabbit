package com.rabbitmqclent.clent.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "boot.queue1", durable = "true"),
                exchange = @Exchange(value = "BOOT-EXCHANGE-1", type = "topic", durable = "true", ignoreDeclarationExceptions = "true"),
                key = "boot.*"
        )
)
@Component
public class MQReceiver {

    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        //手工ack
        channel.basicAck(deliveryTag,true);
        System.out.println("receive--1: " + new String(message.getBody()));
    }

   @RabbitHandler
   public void onUserMessage(@Payload String user, Channel channel, @Headers Map<String,Object> headers) throws IOException {
        long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        //手工ack
        channel.basicAck(deliveryTag,true);
        System.out.println("receive--11: " + user);
   }

}