package com.allen;

import com.allen.dto.DubboResponse;
import com.allen.model.PersonInfo;

public class DemoServiceMock implements DemoService {

    @Override
    public DubboResponse sayHello(String name) {
        DubboResponse response = new DubboResponse();
        response.setCode("success");
        response.setData("出现Rpc异常，进行了mock");
        return response;
    }

    @Override
    public DubboResponse getPersonInfo(String name, String company, String job) {
        return null;
    }

    @Override
    public DubboResponse health() {
        return null;
    }
}
