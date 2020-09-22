package com.misa.fancyLogin.dao;

import com.misa.fancyLogin.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
}
