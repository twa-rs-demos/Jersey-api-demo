package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
import com.thoughtworks.twars.bean.UserDetail;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class UserMapperTest extends TestBase{
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void should_return_user_by_id() throws Exception {
        User user = userMapper.getUserById(1);
        assertThat(user.getMobilePhone(), is("18798037893"));
    }

    @Test
    public void should_return_one_user_by_given_user_mobilePhone() throws Exception{
        User user = userMapper.getUserByMobilePhone("18798037893");
        assertThat(user.getEmail(),is("test@163.com"));
        assertThat(user.getId(),is(1));
        assertThat(user.getMobilePhone(),is("18798037893"));
        assertThat(user.getPassword(),is("550e1bafe077ff0b0b67f4e32f29d751"));
    }

    @Test
    public void should_return_one_user_by_given_user_email() throws Exception{
        User user = userMapper.getUserByEmail("test@163.com");
        assertThat(user.getEmail(),is("test@163.com"));
        assertThat(user.getId(),is(1));
        assertThat(user.getMobilePhone(),is("18798037893"));
        assertThat(user.getPassword(),is("550e1bafe077ff0b0b67f4e32f29d751"));
    }

    @Test
    public void should_insert_an_user() throws Exception{
        User user = new User();
        user.setEmail("547080843@qq.com");
        user.setMobilePhone("18392571954");
        user.setPassword("1234567");
        userMapper.insertUser(user);

        assertThat(user.getId(), is(7));
    }

    @Test
    public void should_return_user_detail_by_id() throws Exception {
        UserDetail detail = userMapper.getUserDetailById(1);

        assertThat(detail.getUserId(), is(1));
        assertThat(detail.getSchool(), is("思沃学院"));
        assertThat(detail.getName(), is("测试一"));
        assertThat(detail.getMajor(), is("计算机"));
        assertThat(detail.getDegree(), is("本科"));
        assertThat(detail.getGender(), is("F"));
        assertThat(detail.getSchoolProvince(), is("陕西"));
        assertThat(detail.getSchoolCity(), is("西安"));
        assertThat(detail.getEntranceYear(),is("2016"));
    }

}
