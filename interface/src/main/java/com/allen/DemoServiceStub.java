package com.allen;

public class DemoServiceStub implements com.allen.DemoService {

    private final com.allen.DemoService demoService;

    // 构造函数传入真正的远程代理对象
    public DemoServiceStub(com.allen.DemoService demoService){
        this.demoService = demoService;
    }

    @Override
    public String sayHello(String name) {
        // 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
        try {
            return demoService.sayHello(name); // safe  null
        } catch (Exception e) {
            // 你可以容错，可以做任何AOP拦截事项
            return "容错数据";
        }
    }
}