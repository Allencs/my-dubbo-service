package com.allen.provider.service;

import com.allen.DemoService;
import com.allen.PersonInfo;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service(version = "default")
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
        personInfo.setMessage("This is Dubbo Service, MyDubboService-Controller.");
        System.out.println(personInfo);
        URL url = RpcContext.getContext().getUrl();
        System.out.println(url);
        return personInfo;  // 正常访问
    }


}
