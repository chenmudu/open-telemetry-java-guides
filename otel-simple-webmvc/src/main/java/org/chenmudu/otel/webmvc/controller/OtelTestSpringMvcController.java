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

import io.opentelemetry.extension.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringMvcTestController.
 */
@Slf4j
@RestController
public class OtelTestSpringMvcController {

    @GetMapping("/hello")
    public String hello() {
        log.info("OtelTestSpringMvcController hello started!");
        this.calledHi();
        return "OtelTestSpringMvcController hello !";
    }

    @WithSpan(value = "testCalledHi")
    private String calledHi() {
        log.info("OtelTestSpringMvcController calledHi started!");
        return "calledHi";
    }
}
