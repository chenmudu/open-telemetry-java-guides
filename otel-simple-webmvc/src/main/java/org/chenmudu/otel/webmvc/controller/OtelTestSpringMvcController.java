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
package org.chenmudu.otel.webmvc.controller;

import ch.qos.logback.classic.Logger;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.opentelemetry.api.common.AttributeKey.stringKey;

/**
 * SpringMvcTestController.
 */
//@Slf4j
@RestController
public class OtelTestSpringMvcController {
    private volatile long counter = 0;

    private static Logger log     = (Logger) LoggerFactory
                                      .getLogger(OtelTestSpringMvcController.class);
    private final Meter meter;

    private final LongCounter longCounter;

    private Attributes attributes = Attributes.of(
                                            stringKey("env"), "dev",
                                            stringKey("author"), "cchen",
                                            stringKey("service"), "otel-simple-webmvc"
                                    );

    {
        meter = GlobalOpenTelemetry.get().getMeter(Class.class.getSimpleName());
        longCounter = meter.counterBuilder("web_mvc_query_counter")
                .setDescription("test for current metric").build();
    }

    @GetMapping("/webmvc")
    public String webmvc() {
        boolean flag = false;
        this.counter++;
        if (this.counter % 2 == 0) {
            try {
                final int i = 1 / 0;
            } catch (Exception e) {
                log.error("error by zero", e);
                longCounter.add(1, attributes.toBuilder().put(String.valueOf(stringKey("success")), flag).build());
                throw e;
            }
        }
        log.info("OtelTestSpringMvcController webmvc!");
        this.calledHi();
        if (this.counter > 100) {
            this.counter = 0;
        }
        flag = true;
        longCounter.add(1L, attributes.toBuilder().put(String.valueOf(stringKey("success")), flag).build());
        return "OtelTestSpringMvcController hello !";
    }

    @WithSpan(value = "biz1")
    private String calledHi() {
        log.info("OtelTestSpringMvcController biz1!");
        calledHi1("admin", "easipass");
        return "calledHi";
    }

    @WithSpan(value = "biz2")
    private String calledHi1(@SpanAttribute("username") final String username,
                             @SpanAttribute("password") final String password) {
        log.info("OtelTestSpringMvcController calledHi1 started!");
        return "calledHi";
    }

}
