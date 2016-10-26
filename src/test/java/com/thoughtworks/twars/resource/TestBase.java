package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionManager;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import javax.ws.rs.core.Application;

public class TestBase extends JerseyTest {
    protected SqlSessionManager sqlSessionManager = mock(SqlSessionManager.class);
    //创建了一个假的sqlSessionManager对象
//    protected UserMapper userMapper = mock(UserMapper.class);
    //创建了一个假的userMapper对象
    @Mock
    protected UserMapper userMapper;

    @Override    //覆盖父类中的方法
    protected Application configure() {
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig().register(new AbstractBinder(){
            @Override
            protected void configure() {
                bind(userMapper).to(UserMapper.class);
                bind(sqlSessionManager).to(SqlSessionManager.class);
            }
        }).packages("com.thoughtworks.twars.resource");
    }
}
