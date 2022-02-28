package com.allen.controller;

import com.allen.DemoService;
import com.allen.dto.DubboResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(loadbalance = "roundrobin", version = "1.0.0")
    private DemoService demoService;

    @RequestMapping(value = "/consumer/user/say", method = RequestMethod.GET)
    public DubboResponse sayHello(@RequestParam(value = "name") String name) {
        return demoService.sayHello(name);
    }

    @RequestMapping(value = "/consumer/user/getPersonInfo", method = RequestMethod.POST)
    public DubboResponse getPersonInfo(@RequestParam(value = "name") String name, @RequestParam(value = "company") String company, @RequestParam(value = "job") String job) {
        DubboResponse result = demoService.getPersonInfo(name, company, job);
        return result;
    }
}
