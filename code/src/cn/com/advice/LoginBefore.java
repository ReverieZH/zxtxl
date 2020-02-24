package cn.com.advice;

import cn.com.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

public class LoginBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("前置通知");
        String username= String.valueOf(objects[0]);
        Logger logger = Logger.getLogger(LoginBefore.class);
        logger.info("\n"+username+"在"+new Date().toString()+"进行登录");
    }
}
