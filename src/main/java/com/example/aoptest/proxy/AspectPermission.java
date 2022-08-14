package com.example.aoptest.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectPermission {

    @Pointcut("@annotation(com.example.aoptest.proxy.IndexPermission)")
    public void point(){

    }
    @Before("point()")
    public void before(){
        System.out.println("check test  =======");
    }



}
