package com.allen;


import com.allen.dto.DubboResponse;
import com.allen.model.PersonInfo;

import java.util.concurrent.CompletableFuture;

public interface DemoService {
    // 同步调用方法
    DubboResponse sayHello(String name);

    DubboResponse getPersonInfo(String name, String company, String job);

    DubboResponse health();

    // 异步调用方法
    default CompletableFuture<DubboResponse> sayHelloAsync(String name) {
        return null;
    };

    // 添加回调
    default String sayHello(String name, String key, com.allen.DemoServiceListener listener) {
        return null;
    };
}
