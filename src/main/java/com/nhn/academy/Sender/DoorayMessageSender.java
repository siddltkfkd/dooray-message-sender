package com.nhn.academy.Sender;

import com.nhn.academy.domain.User;
import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.web.client.RestTemplate;

public class DoorayMessageSender implements MessageSender{
    private String url;

    public DoorayMessageSender() {
    }

    @Override
    public boolean sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), url)
                .send(DoorayHook.builder()
                        .botName(user.getName())
                        .text(message)
                        .build());
        return true;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}