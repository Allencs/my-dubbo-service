package com.allen.controller;

import com.allen.DemoService;
import com.allen.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/consumer/user/say")
    public String sayHello() {
        String result = demoService.sayHello("MyDubboService-Controller");
        return result;
    }

    @RequestMapping("/consumer/user/getPersonInfo")
    public PersonInfo getPersonInfo() {
//        PersonInfo personInfo = new PersonInfo();
//        personInfo.setName("GoodBoy");
//        personInfo.setCompany("PerfMa");
//        personInfo.setJob("PerformanceTestEngineer");
//        personInfo.setCode(200);
//        personInfo.setProtocol("Dubbo");
//        personInfo.setMessage("This is Dubbo Service.");
//        System.out.println(personInfo);

        PersonInfo result = demoService.getPersonInfo("GoodBoy", "PerfMa", "PerformanceTestEngineer");
        return result;
    }
}
