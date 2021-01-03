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
package org.chenmudu.otel.kafka.producer;

import org.chenmudu.otel.kafka.common.CommonConstans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author chenmudu@gmail.com   2021/1/3 16:04
 */
@Component
public class KafkaMqProducer {

    @Autowired
    private KafkaTemplate template;

    /**
     * io.opentelemetry.auto.kafka-clients-0.11
     */
    public void sendMessage() {
        template.send(CommonConstans.TOPIC_NAME, "hi, sofa tracer!");
    }
}
