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
package org.chenmudu.otel.async.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chenmudu@gmail.com   2020/12/19 18:30
 */
@Slf4j
@Controller
public class OtelTestScheduledController {

    /**
     * "io.opentelemetry.javaagent.spring-scheduling"
     */
    @Scheduled(cron = "*/10 * * * * ?")
    public void pushDataScheduled() {
        log.info("start push data scheduled!");
        log.info("current thread name is : {}", Thread.currentThread().getName());
        log.info("scheduled scheduled scheduled scheduled scheduled!!!!!");
        log.info("end push data scheduled!");
    }
}
