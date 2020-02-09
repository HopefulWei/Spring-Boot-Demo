package com.neo.RabiitMQ;

import com.neo.model.Email;
import com.neo.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RabbitListener(queues = "topic.sendcontext")
public class topicReceiver1 {

    @Resource
    com.neo.service.UserService UserService;
    @RabbitHandler
    public void process(Email email) {
        UserService.sendSimpleMail(email.getRecipient(),email.getEmailTilte(),email.getEmailContext());
    }

}