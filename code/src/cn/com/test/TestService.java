package cn.com.test;

import cn.com.mapper.UserMapper;
import cn.com.pojo.Contracts;
import cn.com.service.impl.ContractsServiceImpl;
import cn.com.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestService {
    public static void testUserService() throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userServiceImpl=ac.getBean("userServiceImpl", UserServiceImpl.class);
        boolean issuccess=userServiceImpl.login("reverie","111");
        System.out.println(issuccess);
    }
    public static void testContractsService(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        ContractsServiceImpl contractsServiceImpl=ac.getBean("contractsServiceImpl", ContractsServiceImpl.class);
        List<Contracts> contracts=contractsServiceImpl.getContractsList("reverie",null,null,null,null,null);
        System.out.println(contracts);
    }

    public static void main(String[] args) throws Exception {
        TestService.testUserService();
        TestService.testContractsService();
    }
}
