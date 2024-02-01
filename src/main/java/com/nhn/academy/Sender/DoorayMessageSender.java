package com.nhn.academy.Sender;

import com.nhn.academy.domain.User;
import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;

public class DoorayMessageSender implements MessageSender{
    private DoorayHookSender doorayHookSender;

    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @Override
    public boolean sendMessage(User user, String message) {
        doorayHookSender.send(DoorayHook.builder()
                        .botName(user.getName())
                        .text(message)
                        .build());
        return true;
    }
}