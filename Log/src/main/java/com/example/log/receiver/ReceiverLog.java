package com.example.log.receiver;

import com.example.log.service.LogService;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ReceiverLog {
    private final LogService logService;
    @RabbitListener(queues = "log" , containerFactory = "rabbitListenerContainerFactory")
    public void getMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG)long tag) throws IOException {
        logService.save(message);
        channel.basicAck(tag,false);
    }
}
