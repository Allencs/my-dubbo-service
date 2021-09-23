package com.allen;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * dubbo使用logback
 * 1、maven中排除dubbo log4j的依赖
 * 2、运行时参数添加-Ddubbo.application.logger=slf4j
 * 3、springboot中无须额外添加依赖
 *** Dubbo服务端
 */

@SpringBootApplication
@ImportResource("spring/dubbo-provider.xml")
public class MyDubboService {

    public static void main(String[] args) {
        SpringApplication.run(MyDubboService.class, args);
    }
}
