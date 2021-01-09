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
package org.chenmudu.otel.webflux.web;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author chenmudu@gmail.com   2020/12/14 23:54
 */
@Slf4j
@RestController
public class OtelTestWebFluxController {

    /**
     * io.opentelemetry.javaagent.netty(servlet 容器变成了netty 容器。)
     * io.opentelemetry.javaagent.spring-webflux (web-mvc变成了webflux)
     *
     * @return string.
     */
    @GetMapping("/webFlux")
    public Publisher<String> webFlux() {
        log.info("OtelTestWebFluxController webFlux started!");
        return Mono.just("hi,  webFlux!");
    }
}
