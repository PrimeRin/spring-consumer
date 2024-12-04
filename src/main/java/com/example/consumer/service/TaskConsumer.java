package com.example.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TaskConsumer {

    private final String queueName;

    public TaskConsumer(@Value("${consumer.queue-name}") String queueName) {
        this.queueName = queueName;
    }

    @RabbitListener(queues = "${consumer.queue-name}")
    public void receiveTask(String taskMessage) {
        System.out.println("Task received: " + taskMessage);
    }
}

