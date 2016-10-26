package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
public interface UserMapper {
    int insertUser(User user);

    User getUserByMobilePhone(String mobilePhone);

    User getUserByEmail(String email);



}
