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
import org.chenmudu.otel.async.service.OtelTestAsyncService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chenmudu@gmail.com   2020/12/17 23:54
 */
@Slf4j
@RestController
public class OtelTestAsyncController implements ApplicationContextAware {

    private ApplicationContext   applicationContext;

    @Autowired
    private OtelTestAsyncService otelTestAsyncService;

    @GetMapping("/async")
    public String async() {

        log.info("OtelTestAsyncController async thread name : {}", Thread.currentThread().getName());

        otelTestAsyncService.calledAsync();

        //        this.testCalledAsync();

        this.applicationContext.getBean(OtelTestAsyncController.class).testCalledAsyncByProxy();

        return "async";
    }

    //    @Async
    //    public String testCalledAsync() {
    //        log.info("OtelTestAsyncController testCalledAsync thread name : {}", Thread.currentThread().getName());
    //        return "testCalledAsync";
    //    }
    //@Async
    @Async("cchenThreadExector")
    public String testCalledAsyncByProxy() {
        log.info("OtelTestAsyncController testCalledAsyncByProxy thread name : {}", Thread
            .currentThread().getName());
        return "testCalledAsyncByProxy";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
