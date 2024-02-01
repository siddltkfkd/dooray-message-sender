package com.nhn.academy;

import com.nhn.academy.domain.User;
import com.nhn.academy.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSendService service = context.getBean("messageSendService", MessageSendService.class);
            service.sendMessage(new User("이은지"), "메세지");
        }
    }
}