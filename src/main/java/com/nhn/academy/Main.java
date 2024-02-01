package com.nhn.academy;

import com.nhn.academy.Sender.DoorayMessageSender;
import com.nhn.academy.domain.User;
import com.nhn.academy.service.MessageSendService;

public class Main {
    public static void main(String[] args) {
        MessageSendService service = new MessageSendService();
        DoorayMessageSender sender = new DoorayMessageSender();
        sender.setUrl("https://hook.dooray.com/services/3204376758577275363/3727911831849652136/t0TgHWJ1S9SWgyLnHKk53Q");
        service.setMessageSender(sender);
        service.sendMessage(new User("이은지"), "메세지");
    }
}