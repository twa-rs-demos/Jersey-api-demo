package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
public interface UserMapper {
    User getUserByMobilePhone(String mobilePhone);
    User getUserByEmail(String email);
}
