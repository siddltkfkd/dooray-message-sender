package com.nhn.academy.aspect;

import com.nhn.academy.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StopWatch;

@Aspect
public class CommonAspect {
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
            System.out.println(pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName() + " " + stopWatch.getTotalTimeMillis() + " ms");
        }
    }
}
