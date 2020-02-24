package cn.com.mapper;

import cn.com.pojo.User;

public interface UserMapper {
    public void update(User user);
    public User getUserByName(String username);
}
