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
package org.chenmudu.otel.rabbit.producer;

import org.chenmudu.otel.rabbit.config.CommonConstans;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author chenmudu@gmail.com   2021/1/3 14:55
 */
@Component
public class RabbitMqProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * io.opentelemetry.auto.rabbitmq-amqp
     */
    public void sendMessage() {
        amqpTemplate.convertAndSend(CommonConstans.EXCHANGE_NAME, CommonConstans.ROUNTING_KEY,
            "hi, tracer!");
    }
}
