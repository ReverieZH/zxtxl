package cn.com.test;

import cn.com.mapper.ContractsMapper;
import cn.com.mapper.UserMapper;
import cn.com.pojo.Contracts;
import cn.com.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestMapper {
    public static void testUserMapper(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper=ac.getBean("userMapper",UserMapper.class);
        /*User user=userMapper.getUserByName("reverie");
        System.out.println(user); */
        User user=new User();
        user.setUsername("reverie");
        user.setPassword("111");
        userMapper.update(user);

    }

    public static void testContractsMapper(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        ContractsMapper contractsMapper=ac.getBean("contractsMapper",ContractsMapper.class);
        User user=new User();
        user.setUsername("reverie");
        /*String maxcid=contractsMapper.selectMaxCidByUsername("zhangsan");
        System.out.println(maxcid);   //成功*/

        /*Contracts contracts=new Contracts();
        contracts.setCid("reverie006");
        contracts.setName("hhh");
        contracts.setPhone("12315");
        contracts.setUsername("reverie");
        contractsMapper.addContracts(contracts);  //成功*/

     /*   Contracts contracts=new Contracts();
        contracts.setCid("reverie005");
        contracts.setName("test");
        contracts.setPhone("12315");
        contracts.setUsername("reverie");
        contractsMapper.updateContracts(contracts); //成功*/


       /* contractsMapper.deleteContracts("reverie005"); //成功*/

       /* List<String> cidList=new ArrayList<>();
        cidList.add("reverie004");
        cidList.add("reverie003");
        cidList.add("reverie002");
        contractsMapper.deleteContractsList(cidList);  //成功*/


       /*Contracts contracts=contractsMapper.getContractsById("reverie001");
        System.out.println(contracts);  //成功*/


       List<Contracts> contracts=contractsMapper.getContractsList("zhangsan",null,null,null,null,null);
        System.out.println(contracts);  //成功
    }

    public static void main(String[] args) {
       // TestMapper.testUserMapper();  //成功
        TestMapper.testContractsMapper();  //成功


    }
}
