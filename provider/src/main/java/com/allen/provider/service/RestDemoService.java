package com.allen.provider.service;

import com.allen.DemoService;
import com.allen.dto.DubboResponse;
import com.allen.model.PersonInfo;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


//@Service(version = "rest", protocol = "p2")
@Path("demo")
public class RestDemoService implements DemoService {

    @GET
    @Path("say")
    @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
    @Override
    public DubboResponse sayHello(@QueryParam("name") String name) {
        System.out.println("执行了rest服务" + name);
        URL url = RpcContext.getContext().getUrl();
        DubboResponse response = new DubboResponse();
        response.setData(String.format("%s: %s, Hello, %s", url.getProtocol(), url.getPort(), name));
        response.setCode("success");
        return response;  // 正常访问
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
