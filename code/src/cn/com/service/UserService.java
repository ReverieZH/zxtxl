package cn.com.service;

import cn.com.mapper.UserMapper;

public interface UserService {
    public boolean login(String username,String password) throws Exception;

    public void changePassword(String username,String oldpassword,String newpassword) throws Exception;
}
