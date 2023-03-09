package com.demo.test.service;


import com.demo.test.config.DemoProperties;

public class HelloServiceImpl implements HelloService {
    private DemoProperties demoProperties;
    public HelloServiceImpl(DemoProperties demoProperties){
        this.demoProperties = demoProperties;
    }
    public String sayHi(String agrs) {
        return "say:"+agrs;
    }
}
