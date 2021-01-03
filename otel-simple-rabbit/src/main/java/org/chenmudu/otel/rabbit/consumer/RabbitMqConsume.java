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
package org.chenmudu.otel.rabbit.consumer;

import org.chenmudu.otel.rabbit.config.CommonConstans;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *  ConsumeMessage.
 *
 * @author chenchen6   2020/8/1 22:48
 */
@Component
public class RabbitMqConsume {

    /**
     * io.opentelemetry.auto.rabbitmq-amqp
     * @param message
     */
    @RabbitListener(queues = CommonConstans.QUENE_NAME)
    @RabbitHandler
    public void handleMessage(String message) {
        //consume message
    }
}
