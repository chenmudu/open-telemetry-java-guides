### Open-Telemetry-Simple-Webmvc 案例工程

> Open-Telemetry-Simple-Webmvc 实际测试了 servlet 以及 spring-webmvc。

##### 测试模块快速开始

1. 确保[Guides 案例工程下的步骤](../README.md)执行完毕。

2. 启动此模块[otel-simple-webmvc](https://github.com/chenmudu/open-telemetry-java-guides/tree/master/otel-simple-webmvc/src/main/java/org/chenmudu/otel/webmvc)下的WebMvcRunMain.

3. 访问http://localhost:10001/hello。

4. Copy Console 中的 TraceId访问 http://localhost:16686/ 即可观测结果。

##### 注意

1. 当你使用想观测