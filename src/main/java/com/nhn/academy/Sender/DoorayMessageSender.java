package com.nhn.academy.Sender;

import com.nhn.academy.annotation.Dooray;
import com.nhn.academy.domain.User;
import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Autowired;

public class DoorayMessageSender implements MessageSender{
    @Autowired
    private DoorayHookSender doorayHookSender;

    public DoorayMessageSender() {
    }

    @Dooray
    @Override
    public boolean sendMessage(User user, String message) {
        doorayHookSender.send(DoorayHook.builder()
                        .botName(user.getName())
                        .text(message)
                        .build());
        return true;
    }
}