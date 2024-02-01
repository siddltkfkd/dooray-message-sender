package com.nhn.academy.Sender;

import com.nhn.academy.domain.User;

public interface MessageSender {
    public boolean sendMessage(User user, String message);
}
