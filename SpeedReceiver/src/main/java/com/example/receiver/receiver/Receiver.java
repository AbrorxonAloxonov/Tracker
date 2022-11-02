package com.example.receiver.receiver;

import com.example.receiver.entity.RootEntity;
import com.example.receiver.model.Root;
import com.example.receiver.service.ReceiverService;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Receiver {
    private final ReceiverService saveService;
    @RabbitListener(queues = "speed", containerFactory = "prefetchTenRabbitListenerContainerFactory")// authowired qilish uchun
//    @RabbitListener(queues = "log")
    public void getMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
//        channel.basicQos(2);
//        Thread.sleep(10000);
//        System.out.println(message);
//        Root root = new Root(message);
//        saveService.save(root);
//        System.out.println("ok");
//        channel.basicAck(tag,false);

        Gson gson = new Gson();
        Root json = gson.fromJson(message, Root.class);
        RootEntity rootEntity = new RootEntity(json.getId(),json.getSpeed(),json.getLon(),json.getLat());
        saveService.save(rootEntity);
    }
}
