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
package org.chenmudu.otel.rdb.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * @author chenmudu@gmail.com   2020/12/17 23:54
 */
@Slf4j
@RestController
public class OtelTestRdbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *"io.opentelemetry.auto.jdbc“
     *
     */
    @GetMapping("/testAllDb")
    public JsonNode testAllDb() {
        //
        log.info("OtelTestRdbController testAllDb success!");
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from userinfo");
        return new ObjectMapper().valueToTree("123");
    }

}
