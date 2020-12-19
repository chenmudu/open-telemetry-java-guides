### Open-Telemetry-Simple-Rdb 案例工程

> Open-Telemetry-Simple-Rdb 实际测试了 jdbc 以及 spring-jdbc-template相关。

##### 测试模块快速开始

1. 确保[Guides 案例工程下的步骤](../README.md)执行完毕。

2. 启动此模块[otel-simple-rdb](https://github.com/chenmudu/open-telemetry-java-guides/tree/master/otel-simple-rdb/src/main/java/org/chenmudu/otel/rdb)下的RdbRunMain.

3. 访问http://localhost:10004/testAllDb。

4. Copy Console 中的 TraceId访问 http://localhost:16686/ 即可观测结果。