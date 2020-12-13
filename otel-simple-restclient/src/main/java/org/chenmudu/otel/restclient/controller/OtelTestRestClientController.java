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
package org.chenmudu.otel.restclient.controller;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.chenmudu.otel.restclient.httpclient.HttpAsyncClientInstance;
import org.chenmudu.otel.restclient.httpclient.HttpClientInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * OtelTestRestClientController.
 */
@Slf4j
@RestController
public class OtelTestRestClientController {

    private final String mappingName = "sayHi";

    private final String uri         = "http://localhost:";

    @Value("${server.port}")
    private Integer      port;

    @GetMapping("/rest")
    public String rest() throws Exception {
        log.info("OtelTestRestClientController started!");
        httpClient();
        asyncHttpClient();
        restTemplate();
        connectionUrl();
        syncOkHttp();
        asyncOkHttp();
        return "OtelTestRestClientController hello !";
    }

    /**
     * apache http client.   by io.opentelemetry.javaagent.apache-httpclient.
     * @return
     * @throws Exception
     */
    private String httpClient() throws Exception {
        return new HttpClientInstance(-1).executeGet(uri + port + "/" + mappingName + 1);
    }

    @Autowired
    private RestTemplate restTemplate;

    /**
     * not support, But wrongly think this is apache httpclient。
     * @return
     */
    private String restTemplate() {
        return restTemplate.getForObject(uri + port + "/" + mappingName + 3, String.class);
    }

    @Autowired
    private AsyncRestTemplate asyncRestTemplate;

    /**
     * not support!
     * @return
     */
    private ListenableFuture<ResponseEntity<String>> asyncRestTemplate() {
        return asyncRestTemplate.getForEntity(uri + port + "/" + mappingName + 4, String.class);
    }

    /**
     * apache async http client. by io.opentelemetry.javaagent.apache-httpasyncclient
     * @return
     * @throws Exception
     */
    private String asyncHttpClient() throws Exception {
        return new HttpAsyncClientInstance().executeGet(uri + port + "/" + mappingName + 2);
    }

    /**
     * http-url-connection.  by io.opentelemetry.javaagent.http-url-connection.
     * @return
     */
    private String connectionUrl() {
        return HttpUtil.get(uri + port + "/" + mappingName + 4);
    }

    /**
     * sync okhttp.  by io.opentelemetry.javaagent.okhttp. 没有区分异步同步。
     * @return
     * @throws IOException
     */
    private String syncOkHttp() throws IOException {
        Response response = new OkHttpClient().newCall(
            new Request.Builder().url(uri + port + "/" + mappingName + 5).build()).execute();
        log.info("okhttp resp is : {}", response.body().toString());
        return response.isSuccessful() ? response.body().string() : null;
    }

    /***
     * okhttp  by io.opentelemetry.javaagent.okhttp. 没有区分异步同步。
     * @return
     * @throws IOException
     */
    private String asyncOkHttp() throws IOException {
        final String[] result = new String[1];
        new OkHttpClient().newCall(
            new Request.Builder().url(uri + port + "/" + mappingName + 6).build()).enqueue(
            new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    result[0] = call.toString();
                    log.error("failure, and exception info : {}", e.getStackTrace());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    result[0] = response.body().string();
                }
            });
        return result[0];
    }

}
