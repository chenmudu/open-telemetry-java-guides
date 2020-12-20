### Open-Telemetry-Simple-SpringData 案例工程

> Open-Telemetry-Simple-SpringData 实际测试了Spring-Data下主流中间件的使用。
- spring-data-jpa

- spring-data-jdbc

- spring-data-rest

- spring-data-redis(lettuce/jedis)

- spring-data-mongo


##### 测试模块快速开始

1. 确保[Guides 案例工程下的步骤](../README.md)执行完毕。

2. 启动此模块[otel-simple-spring-data](https://github.com/chenmudu/open-telemetry-java-guides/tree/master/otel-simple-spring-data/src/main/java/org/chenmudu/otel/springdata)下的SpringDataRunMain.

3. 访问http://localhost:10006/springData。

4. Copy Console 中的 TraceId访问 http://localhost:16686/ 即可观测结果。