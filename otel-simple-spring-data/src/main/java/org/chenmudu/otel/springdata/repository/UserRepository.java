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
package org.chenmudu.otel.springdata.repository;

import org.chenmudu.otel.springdata.entity.UserInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring-data-rest-api + jpa：
 *
 * io.opentelemetry.javaagent.servlet
 *
 * io.opentelemetry.javaagent.spring-webmvc
 *
 * io.opentelemetry.javaagent.spring-data
 *
 * io.opentelemetry.javaagent.jdbc
 *
 * @author chenmudu@gmail.com   2020/12/20 22:05
 */
public interface UserRepository extends JpaRepository<UserInfoTable, Integer> {
}
