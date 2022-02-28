package com.allen.provider.service;

import com.allen.DemoService;
import com.allen.dto.DubboResponse;
import com.allen.model.PersonInfo;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(version = "1.0.0", interfaceClass = com.allen.DemoService.class)
public class DefaultDemoService implements DemoService {

    private final Logger logger = LoggerFactory.getLogger(DefaultDemoService.class);

    @Override
    public DubboResponse sayHello(String name) {
//        System.out.println("执行了服务" + name);

        URL url = RpcContext.getContext().getUrl();
        try {
            // 睡眠2s，模拟慢方法
            Thread.sleep(2000);
            logger.info("业务方法执行结束 | name: " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DubboResponse response = new DubboResponse();
        response.setData(String.format("%s：%s, Hello, %s ｜ Thread: %s", url.getProtocol(), url.getPort(), name, Thread.currentThread().getName()));
        response.setCode("success");
        // 正常访问
        return response;
    }

    @Override
    public DubboResponse getPersonInfo(String name, String company, String job) {
        logger.info("执行了服务-获取用户信息");
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName(name);
        personInfo.setCompany(company);
        personInfo.setJob(job);
        personInfo.setCode(200);
        personInfo.setProtocol("Dubbo");
        if (name.equals("TestDubbo")) {
            personInfo.setMessage("Hello Tester! Everything is OK!");
        } else {
            personInfo.setMessage("This is Dubbo Service --> [Query PersonInfo]");
        }
        URL url = RpcContext.getContext().getUrl();
//        System.out.println("Request Url --> " + url);
        logger.info(String.format("Name: %s - Job: %s - Company: %s", personInfo.getName(), personInfo.getJob(), personInfo.getCompany()));
        DubboResponse response = new DubboResponse();
        response.setCode("success");
        response.setData(personInfo);
        return response;  // 正常访问
    }

    @Override
    public DubboResponse health() {
        URL url = RpcContext.getContext().getUrl();
        DubboResponse response = new DubboResponse();
        response.setCode("healthy");
        response.setData("Dubbo Service: " + url);
        return response;
    }


}
