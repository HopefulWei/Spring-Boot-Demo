package com.neo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    final static String sendcontext = "topic.sendcontext";
    final static String sendFile = "topic.sendFile";
    final static String sendPicture = "topic.sendPicture";
    @Bean
    public Queue queueSendcontext() {
        return new Queue(RabbitMQConfig.sendcontext);
    }

    @Bean
    public Queue queueSendFile() {
        return new Queue(RabbitMQConfig.sendFile);
    }

    @Bean
    public Queue queueSendPicture() {
        return new Queue(RabbitMQConfig.sendPicture);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeSendcontext(Queue queueSendcontext, TopicExchange exchange) {
        return BindingBuilder.bind(queueSendcontext).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeSendFile(Queue queueSendFile, TopicExchange exchange) {
        return BindingBuilder.bind(queueSendFile).to(exchange).with("topic.#");
    }

    @Bean
    Binding bindingExchangeSendPicture(Queue queueSendPicture, TopicExchange exchange) {
        return BindingBuilder.bind(queueSendPicture).to(exchange).with("topic.#");
    }

    /**
     * 定义消息转换实例
     * @return
     */
    //Jackson是一个流行的基于Java的JSON处理框架，可以处理json与对象的互换
    //JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式。易于人阅读和编写。同时也易于机器解析和生成。
    //Jackson2JsonMessageConverter将对象转换为json传递给rabbitmq
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}