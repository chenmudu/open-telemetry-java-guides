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
package org.chenmudu.otel.restclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chenmudu@gmail.com   2020/12/13 15:38
 */

@RestController
public class OtelSayHiController {

    @GetMapping("/sayHi1")
    public String sayHi1() {
        return "Hi";
    }

    @GetMapping("/sayHi2")
    public String sayHi2() {
        return "Hi";
    }

    @GetMapping("/sayHi3")
    public String sayHi3() {
        return "Hi";
    }

    @GetMapping("/sayHi4")
    public String sayHi4() {
        return "Hi";
    }

    @GetMapping("/sayHi5")
    public String sayHi5() {
        return "Hi";
    }

    @GetMapping("/sayHi6")
    public String sayHi6() {
        return "Hi";
    }
}
