package com.delivery.app.restaurant.rabbitmq;

import com.delivery.app.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantRabbitMqConfig extends RabbitMqConfig {

    /*@Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
                                                                   MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(ORDER_QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(OrderStatusConsumer orderConsumer) {
        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(orderConsumer, "receiveMessage");
        listenerAdapter.setMessageConverter(jsonMessageConverter());
        return listenerAdapter;
    }*/
}
