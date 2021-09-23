package com.allen;


import com.allen.model.PersonInfo;

import java.util.concurrent.CompletableFuture;

public interface DemoService {
    // 同步调用方法
    String sayHello(String name);

    PersonInfo getPersonInfo(String name, String company, String job);

    // 异步调用方法
    default CompletableFuture<String> sayHelloAsync(String name) {
        return null;
    };

    // 添加回调
    default String sayHello(String name, String key, com.allen.DemoServiceListener listener) {
        return null;
    };
}
