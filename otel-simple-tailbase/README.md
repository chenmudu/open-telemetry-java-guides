### Open-Telemetry-Simple-TailBased 案例工程

> Open-Telemetry-Simple-TailBased 实际测试了 Otel-Col 对 Trace Data 的采样规则。

##### 测试模块快速开始

1. 确保[Guides 案例工程下的步骤](../README.md)执行完毕。

2. 启动此模块[otel-simple-tailbase](https://github.com/chenmudu/open-telemetry-java-guides/tree/master/otel-simple-tailbase/src/main/java/org/chenmudu/otel/tailbase)TailBasedRunMain.

3. 访问http://localhost:10009/tailbased。

4. Copy Console 中的 TraceId访问 http://localhost:16686/ 即可观测结果。

##### 注意

1. 保证当前Otel-Col-Contrib已启动，[关于脚本](https://github.com/chenmudu/open-telemetry-java-guides/blob/master/config/others.properties)。

1. 保证当前Otel-Col-Contrib的配置符合你的需求，详情查看[我的配置](https://github.com/chenmudu/open-telemetry-java-guides/blob/master/config/otel-col-contrib-config.yaml)。
