package cn.com.service.impl;

import cn.com.mapper.UserMapper;
import cn.com.pojo.User;
import cn.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) throws Exception {
        User user=userMapper.getUserByName(username);
        if (user==null)
            throw new Exception("用户名不存在");
        if(!user.getPassword().equals(password))
            throw new Exception("密码不正确");
        System.out.println("----");
        return true;
    }

    @Override
    public void changePassword(String username, String oldpassword,String newpassword) throws Exception {
        User user=userMapper.getUserByName(username);
        if (user==null)
            throw new Exception("用户名不存在");
        if(!user.getPassword().equals(oldpassword))
            throw new Exception("原密码不正确");
        user.setPassword(newpassword);
        try {
            userMapper.update(user);
        } catch (Exception e) {
            System.out.println("changePassword事务回滚");
            throw new RuntimeException("changePassword事务回滚");
        }
    }
}
