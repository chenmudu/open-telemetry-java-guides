/**
 * MIT License
 * <p>
 * Copyright (c) 2019 chenmudu (陈晨)
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 */
package org.chenmudu.otel.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  RabbitConfig.
 *
 * @author chenchen6   2021/01/02 22:48
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Exchange exchange() {
        return new TopicExchange(CommonConstans.EXCHANGE_NAME);
    }

    @Bean
    public Queue queue() {
        return new Queue(CommonConstans.QUENE_NAME);
    }

    @Bean
    public Binding bindingFirstQueueToExchangeWithRoutingKey() {
        return BindingBuilder.bind(queue()).to(exchange()).with(CommonConstans.ROUNTING_KEY)
            .noargs();
    }
}
