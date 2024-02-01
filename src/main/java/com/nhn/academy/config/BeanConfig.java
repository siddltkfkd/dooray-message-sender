package com.nhn.academy.config;

import com.nhn.academy.Sender.DoorayMessageSender;
import com.nhn.academy.aspect.LoggingAspect;
import com.nhn.academy.service.MessageSendService;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = "classpath:dooray.property", encoding = "utf-8")
@EnableAspectJAutoProxy
public class BeanConfig {
    private String url = "https://hook.dooray.com/services/3204376758577275363/3727911831849652136/t0TgHWJ1S9SWgyLnHKk53Q";

    @Bean
    public DoorayHookSender doorayHookSender(){
        return new DoorayHookSender(new RestTemplate(), url);
    }

    @Bean
    public DoorayMessageSender doorayMessageSender(){
        return new DoorayMessageSender();
    }

    @Bean
    public MessageSendService messageSendService(){
        return new MessageSendService();
    }

    @Bean
    public LoggingAspect commonAspect(){
        return new LoggingAspect();
    }
}
