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
package org.chenmudu.otel.rabbit.controller;

import lombok.extern.slf4j.Slf4j;
import org.chenmudu.otel.rabbit.producer.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chenmudu@gmail.com   2021/1/3 14:57
 */
@Slf4j
@RestController
public class OtelTestRabbitController {

    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    /**
     * io.opentelemetry.auto.rabbitmq-amqp
     * @return
     */
    @GetMapping("rabbitmq")
    public String testRabbitMq() {
        log.info("OtelTestRabbitController started!");
        rabbitMqProducer.sendMessage();
        return "hi,otel!";
    }
}
