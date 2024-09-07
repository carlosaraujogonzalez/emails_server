package com.gbtec.emailservertest.components;

import org.springframework.stereotype.Component;

import com.gbtec.emailservertest.service.MarkSpamService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Slf4j
public class RabbitMQReceiver {

    @Autowired
    MarkSpamService markSpamService;
    
    @RabbitListener(queues = "${email.rabbitmq.queue}")
    public void recievedMessage(String incomingMessage) {

        System.out.println("Recieved Message From RabbitMQ: " + incomingMessage);
        
    	log.info("markSpamService - Start");
    	
    	markSpamService.markSpam( incomingMessage);
    	
    	log.info("markSpamService - End");
    }
}
