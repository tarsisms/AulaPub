package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;

public class Sub {

    public static void main(String[] args) {

        final String queueName = "send-email";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");

        try {

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            Consumer consumer = new MyConsumer(channel);
            channel.basicConsume(queueName, true, consumer);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
