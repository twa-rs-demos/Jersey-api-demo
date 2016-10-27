package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceTest extends TestBase{
    String basePath="/register";

    @Test
    public void should_create_user_when_register() {
        User newUser = new User();

        when(userMapper.insertUser(newUser)).thenReturn(1);
        newUser.setEmail("abc@cba.com");
        newUser.setMobilePhone("123");
        newUser.setId(123);
        newUser.setPassword("123456");
        Entity entity = Entity.entity(newUser, MediaType.APPLICATION_JSON);
        Response response = target(basePath).request().post(entity);
        assertThat(response.getStatus(), is(200));
        Map result = response.readEntity(Map.class);

        String userUri = (String) ((Map) result.get("user")).get("uri");
        String userInfoUri = (String) ((Map) result.get("userInfo")).get("uri");

        assertThat(userUri,is("user/123"));
        assertThat(userInfoUri,is("userInfo/123"));
    }
}
