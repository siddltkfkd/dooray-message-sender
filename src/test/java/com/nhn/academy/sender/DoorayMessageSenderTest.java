package com.nhn.academy.sender;

import com.nhn.academy.Sender.DoorayMessageSender;
import com.nhn.academy.domain.User;
import com.nhn.dooray.client.DoorayHookSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;

public class DoorayMessageSenderTest {
    @Mock
    private DoorayHookSender doorayHookSender;
    @InjectMocks
    private DoorayMessageSender doorayMessageSender;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void verifySendMessage(){
        doorayMessageSender.sendMessage(new User("테스트"), "테스트 메세지");
        Mockito.verify(doorayHookSender).send(any());
    }

    @Test
    void verifySendMessageCount(){
        doorayMessageSender.sendMessage(new User("테스트"), "테스트 메세지");
        doorayMessageSender.sendMessage(new User("테스트"), "테스트 메세지");
        doorayMessageSender.sendMessage(new User("테스트"), "테스트 메세지");
        Mockito.verify(doorayHookSender, Mockito.times(3)).send(any());
    }
}
