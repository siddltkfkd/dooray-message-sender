package com.nhn.academy.aspect;

import com.nhn.academy.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Value("${name}")
    private String name;
    @Value("${message}")
    private String message;
    @Around("args(user, ..) && @annotation(com.nhn.academy.annotation.Dooray)")
    private Object dooraySendMessage(ProceedingJoinPoint pjp, User user) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try{
            user.setName(name);
            return pjp.proceed(new Object[] {user, this.message});
        } finally {
            stopWatch.stop();
            log.info("[{}].[{}] [{}]ms", pjp.getTarget().getClass().getSimpleName(), pjp.getSignature().getName(), stopWatch.getTotalTimeMillis());
        }
    }
}
