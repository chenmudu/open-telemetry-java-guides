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
package org.chenmudu.otel.tailbase.controller;

import io.opentelemetry.extension.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chenmudu@gmail.com   2021/1/5 00:16
 */
@Slf4j
@RestController
public class OtelTestTailBaseController {

    private volatile Integer counter = 0;

    @GetMapping("/tailbased")
    public String tailbased() {
        log.info("OtelTestTailBaseController hello started!");
        this.calledHi();
        return "OtelTestTailBaseController hello !";
    }

    @WithSpan(value = "testCalledHi")
    private String calledHi() {
        log.info("OtelTestTailBaseController calledHi started!");
        // 当你配置了tail_base采样规则时即可生效。
        if(counter++ % 2 == 1) {
            int i = 1 /0 ;
        }
        return "calledHi";
    }
}
