package com.misa.fancyLogin.service;

import com.misa.fancyLogin.entity.User;
import com.misa.fancyLogin.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
