package com.demo.test.config;



import com.demo.test.service.HelloService;
import com.demo.test.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(
        prefix = "demo",name = "isOpen",havingValue = "true"
)
@ConditionalOnWebApplication
public class DemoAutoConfig {

    @Autowired
    private DemoProperties demoProperties;

    /**
     * 不存在走兜底的
     */
    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService(){
        //todo 用户没有定义走兜底的
        return new HelloServiceImpl(this.demoProperties);
    }
}
