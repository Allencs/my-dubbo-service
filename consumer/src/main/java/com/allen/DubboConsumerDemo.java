package com.allen;

import com.allen.controller.ConsumerInterceptor;
import com.allen.dto.DubboResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
// xml配置dubbo时使用
//@ImportResource("spring/dubbo-consumer.xml")
public class DubboConsumerDemo implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ConsumerInterceptor());
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DubboConsumerDemo.class, args);
        // dubbo服务健康检查
        DemoService demoService = context.getBean(DemoService.class);
        DubboResponse response = demoService.health();
        System.out.println("健康检查 ==> " + response.toString());
    }

}
