### Open-Telemetry-Simple-Rabbit 案例工程

> Open-Telemetry-Simple-Rabbit 实际测试了 Spring Amqp 以及 Rabbit Client。

##### 测试模块快速开始

1. 确保[Guides 案例工程下的步骤](../README.md)执行完毕。

2. 启动此模块[otel-simple-rabbit](https://github.com/chenmudu/open-telemetry-java-guides/tree/master/otel-simple-rabbit/src/main/java/org/chenmudu/otel/rabbit)下的 RabbitMqMvcRunMain .

3. 访问http://localhost:10007/rabbitmq。

4. Copy Console 中的 TraceId访问 http://localhost:16686/ 即可观测结果。