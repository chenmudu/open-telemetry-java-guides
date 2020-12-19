### Open-Telemetry-Simple-Webflux 案例工程

> Open-Telemetry-Simple-Webflux 实际测试了 webflux 对应netty组件。

##### 测试模块快速开始

1. 确保[Guides 案例工程下的步骤](../README.md)执行完毕。

2. 启动此模块[otel-simple-webflux](https://github.com/chenmudu/open-telemetry-java-guides/tree/master/otel-simple-webflux/src/main/java/org/chenmudu/webflux/webmvc)下的WebFluxRunMain.

3. 访问http://localhost:10003/webFlux。

4. Copy Console 中的 TraceId访问 http://localhost:16686/ 即可观测结果。