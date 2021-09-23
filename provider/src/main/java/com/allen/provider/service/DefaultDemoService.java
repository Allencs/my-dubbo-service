package com.allen.provider.service;

import com.allen.DemoService;
import com.allen.model.PersonInfo;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


//@Service(version = "1.0.0", interfaceClass = com.allen.DemoService.class)
@Component(value = "demoService")
public class DefaultDemoService implements DemoService {

    private final Logger logger = LoggerFactory.getLogger(DefaultDemoService.class);

    @Override
    public String sayHello(String name) {
        System.out.println("执行了服务" + name);

        URL url = RpcContext.getContext().getUrl();
        return String.format("%s：%s, Hello, %s", url.getProtocol(), url.getPort(), name);  // 正常访问
    }

    @Override
    public PersonInfo getPersonInfo(String name, String company, String job) {
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
        System.out.println("Request Url --> " + url);
        logger.info(String.format("Name: %s - Job: %s - Company: %s", personInfo.getName(), personInfo.getJob(), personInfo.getCompany()));
        return personInfo;  // 正常访问
    }


}
