package com.allen;

import com.allen.dto.DubboResponse;
import com.allen.model.PersonInfo;

public class DemoServiceStub implements com.allen.DemoService {

    private final com.allen.DemoService demoService;

    // 构造函数传入真正的远程代理对象
    public DemoServiceStub(com.allen.DemoService demoService){
        this.demoService = demoService;
    }

    @Override
    public DubboResponse sayHello(String name) {
        // 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
        try {
            return demoService.sayHello(name); // safe  null
        } catch (Exception e) {
            DubboResponse response = new DubboResponse();
            response.setCode("failed");
            response.setData("容错数据");
            // 你可以容错，可以做任何AOP拦截事项
            return response;
        }
    }

    @Override
    public DubboResponse getPersonInfo(String name, String company, String job) {
        return null;
    }

    @Override
    public DubboResponse health() {
        return null;
    }
}
