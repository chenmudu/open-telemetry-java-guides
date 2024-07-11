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
package org.chenmudu.otel.kafka.consumer;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.chenmudu.otel.kafka.common.CommonConstans;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author chenmudu@gmail.com   2021/1/3 16:05
 */
@Slf4j
@Component
public class KafkaMqConsume {

    /**
     * io.opentelemetry.auto.kafka-clients
     * @param content str msg.
     */
    @KafkaListener(topics = CommonConstans.TOPIC_NAME)
    @WithSpan
    // 随便
    public void processMessage(@SpanAttribute("bizReciveParam") String content) {
        //consume message.
        log.info("KafkaMqConsume processMessage content msg : {}", content);
        // biz core1
        test21();
        //biz core2
        test22();
    }

    @WithSpan
    private void test21() {
        test211();
        test212();
        test213();
    }

    @WithSpan
    private void test211() {

    }

    @WithSpan
    private void test212() {

    }

    @WithSpan
    private void test213() {

    }

    @WithSpan
    private void test22() {
        test221();
        test222();
    }

    @WithSpan
    private void test221() {

    }

    @WithSpan
    private void test222() {

    }

}
