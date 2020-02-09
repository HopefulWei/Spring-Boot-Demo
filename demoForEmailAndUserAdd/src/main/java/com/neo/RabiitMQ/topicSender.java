package com.neo.RabiitMQ;

import com.neo.model.Email;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class topicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1(Email email) {
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.sendcontext", email);
    }

    public void send2(Email email) {
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.sendFile", email);
    }

    public void send3(Email email) {
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.sendPicture", email);
    }

}