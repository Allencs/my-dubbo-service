package com.allen.provider.service;

import com.allen.DemoService;
import com.allen.dto.DubboResponse;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

//@Service(version = "async", protocol = "p1")
public class AsyncDemoService implements DemoService {

    @Override
    public DubboResponse sayHello(String name) {
        System.out.println("执行了同步服务" + name);
        URL url = RpcContext.getContext().getUrl();
        DubboResponse response = new DubboResponse();
        response.setData(String.format("%s：%s, Hello, %s", url.getProtocol(), url.getPort(), name));
        response.setCode("success");
        return response;  // 正常访问
    }

    @Override
    public DubboResponse getPersonInfo(String name, String company, String job) {
        return null;
    }

    @Override
    public DubboResponse health() {
        return null;
    }

    @Override
    public CompletableFuture<DubboResponse> sayHelloAsync(String name) {
        System.out.println("执行了异步服务" + name);

        return CompletableFuture.supplyAsync(() -> sayHello(name));
    }
}
