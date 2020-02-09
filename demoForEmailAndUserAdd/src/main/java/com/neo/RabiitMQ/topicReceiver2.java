package com.neo.RabiitMQ;

import com.neo.model.Email;
import com.neo.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RabbitListener(queues = "topic.sendFile")
public class topicReceiver2 {
    @Resource
    UserService UserService;
    @RabbitHandler
    public void process(Email email) {
        UserService.sendAttachmentsMail(email.getRecipient(),email.getEmailTilte(),email.getEmailContext(),email.getEmailPath());
    }

}