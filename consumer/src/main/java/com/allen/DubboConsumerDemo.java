package com.allen;

import com.allen.controller.ConsumerInterceptor;
import com.allen.model.PersonInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.io.IOException;

@SpringBootApplication
//@ImportResource("spring/dubbo-consumer.xml")
public class DubboConsumerDemo implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ConsumerInterceptor());
    }

//    @Reference(version = "1.0.0", loadbalance = "roundrobin")

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(DubboConsumerDemo.class, args);
        DemoService demoService = context.getBean(DemoService.class);

//        System.out.println(demoService.sayHello("MyDubboService"));

        PersonInfo personInfo = demoService.getPersonInfo("TestDubbo", "JavaFactory", "Tester");
        System.out.println("测试Dubbo服务：" + personInfo.getMessage());
    }

}
