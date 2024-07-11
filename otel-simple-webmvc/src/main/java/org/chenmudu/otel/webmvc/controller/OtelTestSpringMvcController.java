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
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringMvcTestController.
 */
//@Slf4j
@RestController
public class OtelTestSpringMvcController {
    private volatile long counter = 0;
    private static Logger log     = (Logger) LoggerFactory
                                      .getLogger(OtelTestSpringMvcController.class);

    @GetMapping("/webmvc")
    public String webmvc() {
        counter++;
        if (counter % 2 == 0) {
            try {
                final int i = 1 / 0;
            } catch (Exception e) {
                log.error("error by zero", e);
                throw e;
            }
        }
        log.info("OtelTestSpringMvcController webmvc!");
        this.calledHi();
        if (counter > 100) {
            counter = 0;
        }
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
