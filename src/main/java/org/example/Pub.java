package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Pub {

    /// Conta Bancaria
    // Efetuar Saque > E-mail pro cliente

    // Definir nome da Queue

    // Connection Config
    public static void main(String[] args) {
        final String queueName = "send-email";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");

        try {

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String msg = "Hello World 2!";
            channel.basicPublish("", queueName, null, msg.getBytes("UTF-8"));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}