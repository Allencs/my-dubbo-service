package com.allen;

public class DemoServiceMock implements DemoService {

    @Override
    public String sayHello(String name) {

        return "出现Rpc异常，进行了mock";
    }

    @Override
    public PersonInfo getPersonInfo(String name, String company, String job) {
        return null;
    }
}
