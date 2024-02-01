package com.nhn.academy.service;

import com.nhn.academy.Sender.MessageSender;
import com.nhn.academy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSendService {
    @Autowired
    private MessageSender messageSender;

    public MessageSendService() {
    }

    public void sendMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
