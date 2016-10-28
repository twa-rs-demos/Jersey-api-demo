package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends TestBase {
    String basePath = "/user";

    User user = new User();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        user.setEmail("test2@qq.com");
        user.setId(1);
        user.setMobilePhone("18087839393");
    }

    @Test
    public void should_return_404_when_not_found_user_by_mobilePhone() {
        when(userMapper.getUserByMobilePhone("18829290571")).thenReturn(null);
        Response response = target(basePath + "/mobilePhone/18829290571").request().get();
        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_404_when_not_found_user_by_email() {
        when(userMapper.getUserByEmail("565678159@qq.com")).thenReturn(null);
        Response response = target(basePath + "/email/565678159@qq.com").request().get();
        assertThat(response.getStatus(), is(404));
    }


    @Test
    public void should_return_one_user_by_mobilePhone() {
        when(userMapper.getUserByMobilePhone("18087839393")).thenReturn(user);
        Response response = target(basePath + "/mobilePhone/18087839393").request().get();

        assertThat(response.getStatus(), is(200));
        Map result = response.readEntity(Map.class);  //打印出从数据库找到的user
        assertThat(result.get("email"), is("test2@qq.com"));
        assertThat(result.get("mobilePhone"), is(user.getMobilePhone()));
        assertThat(result.get("id"), is(user.getId()));
//        assertThat(response.getEntity());
    }

    @Test
    public void should_return_one_user_by_email() {
        when(userMapper.getUserByEmail("test2@qq.com")).thenReturn(user);
        Response response = target(basePath + "/email/test2@qq.com").request().get();
        assertThat(response.getStatus(), is(200));
        Map result = response.readEntity(Map.class);  //打印出从数据库找到的user
        assertThat(result.get("email"), is("test2@qq.com"));
        assertThat(result.get("mobilePhone"), is(user.getMobilePhone()));
        assertThat(result.get("id"), is(user.getId()));
    }
}
