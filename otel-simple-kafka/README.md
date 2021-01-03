### Open-Telemetry-Simple-Kafka 案例工程

> Open-Telemetry-Simple-Kafka 实际测试了 Spring Kafka 以及 Kafka Client。

##### 测试模块快速开始

1. 确保[Guides 案例工程下的步骤](../README.md)执行完毕。

2. 启动此模块[otel-simple-kafka](https://github.com/chenmudu/open-telemetry-java-guides/tree/master/otel-simple-kafka/src/main/java/org/chenmudu/otel/kafka)下的 KafkaMqMvcRunMain .

3. 访问http://localhost:10008/kafkamq。

4. Copy Console 中的 TraceId访问 http://localhost:16686/ 即可观测结果。