package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
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
        User user1 = userMapper.getUserByMobilePhone("18798037893");
        assertEquals("test@163.com",user1.getEmail());
        assertEquals(1,user1.getId());
        assertEquals("18798037893",user1.getMobilePhone());
        assertEquals("550e1bafe077ff0b0b67f4e32f29d751",user1.getPassword());
    }

    @Test
    public void should_return_one_user_by_given_user_email() throws Exception{
        User user2 = userMapper.getUserByEmail("test@163.com");
        assertEquals("test@163.com",user2.getEmail());
        assertEquals(1,user2.getId());
        assertEquals("18798037893",user2.getMobilePhone());
        assertEquals("550e1bafe077ff0b0b67f4e32f29d751",user2.getPassword());
    }

    @Test
    public void should_insert_an_user() throws Exception{
        User user = new User();
        user.setEmail("547080843@qq.com");
        user.setMobilePhone("18392571954");
        user.setPassword("1234567");
        userMapper.insertUser(user);

        assertThat(user.getId(), is(Integer.valueOf(7)));
        assertEquals(user.getId(),7);
    }

}
