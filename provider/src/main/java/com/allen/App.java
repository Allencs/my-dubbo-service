package com.allen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * dubbo使用logback
 * 1、maven中排除dubbo log4j的依赖
 * 2、运行时参数添加-Ddubbo.application.logger=slf4j
 * 3、springboot中无须额外添加依赖
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
