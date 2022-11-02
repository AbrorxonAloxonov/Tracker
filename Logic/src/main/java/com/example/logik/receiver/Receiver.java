package com.example.logik.receiver;

import com.example.logik.service.RootService;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Receiver {
    private final RootService service;
    @RabbitListener(queues = "logic", containerFactory = "prefetchTenRabbitListenerContainerFactory")// authowired qilish uchun
    public void getMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
//        System.out.println(message);
        service.saved(message);
    }
}
