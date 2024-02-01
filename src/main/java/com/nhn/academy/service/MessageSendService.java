package com.nhn.academy.service;

import com.nhn.academy.Sender.MessageSender;
import com.nhn.academy.domain.User;

public class MessageSendService {
    private MessageSender messageSender;

    public MessageSendService() {
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
