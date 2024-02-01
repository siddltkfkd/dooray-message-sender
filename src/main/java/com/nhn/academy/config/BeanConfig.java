package com.nhn.academy.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = "classpath:dooray.property", encoding = "utf-8")
@EnableAspectJAutoProxy
@ComponentScan("com.nhn.academy")
public class BeanConfig {
    private String url = "https://hook.dooray.com/services/3204376758577275363/3727911831849652136/t0TgHWJ1S9SWgyLnHKk53Q";

    @Bean
    public DoorayHookSender doorayHookSender(){
        return new DoorayHookSender(new RestTemplate(), url);
    }
}
