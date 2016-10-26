package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMapperTest extends TestBase{
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void should_return_one_user_by_given_user_mobilePhone() throws Exception{
        User user1 = userMapper.getUserByMobilePhone("18829290576");
        assertEquals("565678150@qq.com",user1.getEmail());
        assertEquals(new Integer(1),user1.getId());
        assertEquals("18829290576",user1.getMobilePhone());
        assertEquals("123456789",user1.getPassWord());
    }
    
//    @Test
//    public void should_return_one_user_by_given_user_email() throws Exception{
//        User user2 = userMapper.getUserByEmail("565678150@qq.com");
//        assertEquals("565678150@qq.com",user2.getEmail());
//        assertEquals(new Integer(1),user2.getId());
//        assertEquals("18829290576",user2.getMobilePhone());
//        assertEquals("123456789",user2.getPassWord());
//    }
}
