package com.delivery.app.order.rabbitmq;

import com.delivery.app.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderRabbitMqConfig extends RabbitMqConfig {

    /*@Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
                                                                   MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(RESTAURANT_QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RestaurantStatusConsumer orderConsumer) {
        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(orderConsumer, "receiveMessage");
        listenerAdapter.setMessageConverter(jsonMessageConverter());
        return listenerAdapter;
    }*/
}

