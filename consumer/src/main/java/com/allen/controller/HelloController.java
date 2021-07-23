package com.allen.controller;

import com.allen.DemoService;
import com.allen.model.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/consumer/user/getPersonInfo", method = RequestMethod.POST)
    public PersonInfo getPersonInfo(@RequestParam(value = "name") String name, @RequestParam(value = "company") String company, @RequestParam(value = "job") String job) {
        PersonInfo result = demoService.getPersonInfo(name, company, job);
        return result;
    }
}
