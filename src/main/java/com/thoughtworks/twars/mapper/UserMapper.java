package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
import com.thoughtworks.twars.bean.UserDetail;

public interface UserMapper {
    int insertUser(User user);

    User getUserById(int id);

    User getUserByMobilePhone(String mobilePhone);

    User getUserByEmail(String email);

    UserDetail getUserDetailById(int userId);


}
