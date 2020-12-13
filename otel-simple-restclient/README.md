### Open-Telemetry-Simple-RestClient 案例工程

> Open-Telemetry-Simple-RestClient 实际测试了日常主流所用的Rest Client相关。

##### 测试模块快速开始

1. 确保[Guides 案例工程下的步骤](../README.md)执行完毕。

2. 启动此模块[otel-simple-restclient](https://github.com/chenmudu/open-telemetry-java-guides/tree/master/otel-simple-restclient/src/main/java/org/chenmudu/otel/restclient)下的RestClientRunMain.

3. 访问http://localhost:10002/rest。

4. Copy Console 中的 TraceId访问 http://localhost:16686/ 即可观测结果。