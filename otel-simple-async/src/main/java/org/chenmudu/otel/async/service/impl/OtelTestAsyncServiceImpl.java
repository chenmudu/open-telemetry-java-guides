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
package org.chenmudu.otel.async.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.chenmudu.otel.async.service.OtelTestAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author chenmudu@gmail.com   2020/12/17 23:45
 */
@Slf4j
@Service
public class OtelTestAsyncServiceImpl implements OtelTestAsyncService {

    @Async
    @Override
    public String calledAsync() {
        log.info("OtelTestAsyncServiceImpl calledAsync thread is : {}", Thread.currentThread()
            .getName());
        return "calledAsync";
    }
}
