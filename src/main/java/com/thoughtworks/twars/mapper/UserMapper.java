package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
import com.thoughtworks.twars.bean.UserDetail;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int insertUser(User user);

    User getUserById(int id);

    User getUserByMobilePhone(String mobilePhone);

    User getUserByEmail(String email);

    UserDetail getUserDetailById(int userId);

    int updateUserDetail(UserDetail detail);

    int updatePassword(
            @Param("id") int id,
            @Param("oldPassword") String oldPassword,
            @Param("password") String password);

}
