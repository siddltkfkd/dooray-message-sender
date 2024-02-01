package com.nhn.academy;

import com.nhn.academy.config.BeanConfig;
import com.nhn.academy.domain.User;
import com.nhn.academy.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        MessageSendService service = context.getBean("messageSendService", MessageSendService.class);
        service.sendMessage(new User("이름"), "메세지");
    }
}