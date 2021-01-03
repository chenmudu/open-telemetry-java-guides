/**
 * MIT License
 * <p>
 * Copyright (c) 2020 chenmudu (陈晨)
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
 */
package org.chenmudu.otel.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.chenmudu.otel.kafka.producer.KafkaMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chenmudu@gmail.com   2021/1/3 14:57
 */
@Slf4j
@RestController
public class OtelTestKafkaController {

    @Autowired
    private KafkaMqProducer kafkaMqProducer;

    @GetMapping("kafkamq")
    public String testKafkaMq() {
        log.info("OtelTestKafkaController testKafkaMq started!");
        kafkaMqProducer.sendMessage();
        return "hi,otel!";
    }
}
