package cn.com.advice;


import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LoginAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("后置通知");
        Logger logger = Logger.getLogger(LoginAfter.class);
        String username = String.valueOf(objects[0]);
        System.out.println(o);
        if(o!=null){
            logger.info(username+"登录成功!\n");
        }else{
            logger.info(username+"登录失败!\n");
        }
    }
}
