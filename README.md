# Dubbo Demo服务
基于SpringBoot的dubbo服务，包含服务端，消费端，接口，通用类模块

### provider模块
- 异步 AsyncDemoService
- 回调 CallBackDemoService
- 默认 DefaultDemoService（主要）
- 通用 GenericDemoService
- rest RestDemoService
- 超时 TimeoutDemoService

### consumer模块
- 包含所有provider类型，另外还有负载均衡、集群等消费端demo
- 包装成通用restful接口，可使用http调用

