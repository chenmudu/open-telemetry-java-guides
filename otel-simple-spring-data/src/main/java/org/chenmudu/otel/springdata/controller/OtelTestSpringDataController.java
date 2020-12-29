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
package org.chenmudu.otel.springdata.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.chenmudu.otel.springdata.entity.UserInfoDocument;
import org.chenmudu.otel.springdata.entity.UserInfoEsDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * SpringMvcTestController.
 */
@Slf4j
@RestController
public class OtelTestSpringDataController {

    @Autowired
    private MongoTemplate         mongoTemplate;

    @Autowired
    private RedisTemplate         redisTemplate;

    @Autowired
    private JdbcTemplate          jdbcTemplate;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @GetMapping("/springData")
    public String springData() {
        log.info("OtelTestSpringMvcController hello started!");
        //        this.dataMongoTest();
        //        this.dataRedisTest();
        //        this.dataJdbcTest();
        this.dataCreateElasticSearchIndex();
        return "OtelTestSpringMvcController hello !";
    }

    /**
     *
     * "io.opentelemetry.javaagent.mongo"
     */
    private JsonNode dataMongoTest() {
        //        UserInfoDocument userInfo = new UserInfoDocument();
        //        userInfo.setName("cchen");
        //        userInfo.setAge(22);
        //        UserInfoDocument insertUserInfo = mongoTemplate.save(userInfo);
        //        log.info("current onsert user info values : {}", insertUserInfo);
        List<UserInfoDocument> all = mongoTemplate.findAll(UserInfoDocument.class);
        return new ObjectMapper().valueToTree(all);
    }

    /**
     * io.opentelemetry.auto.lettuce-5.1
     *
     * io.opentelemetry.javaagent.jedis
     */
    private void dataRedisTest() {
        Boolean flag = redisTemplate.hasKey("cchen");
        log.info("current redis had cchen? : {}", flag);
    }

    /**
     * "io.opentelemetry.javaagent.jdbc"
     */
    private void dataJdbcTest() {
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from userinfo");
        JsonNode jsonNode = new ObjectMapper().valueToTree("123");
        log.info("data jdbc query result is : {}", jsonNode);
    }

    /**
     * ”io.opentelemetry.javaagent.elasticsearch“
     */
    private String dataCreateElasticSearchIndex() {
        boolean indexFlag = esTemplate.createIndex(UserInfoEsDocument.class);
        log.info("dataElasticsearch create index result : {}", indexFlag);
        boolean putFlag = esTemplate.putMapping(UserInfoEsDocument.class);
        log.info("dataElasticsearch put index result : {}", putFlag);
        return indexFlag + " ==== " + putFlag;
    }

}
