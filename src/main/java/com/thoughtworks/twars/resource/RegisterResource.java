package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.User;
import com.thoughtworks.twars.mapper.UserMapper;
import com.wordnik.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/register")

public class RegisterResource {
    @Inject
    private UserMapper userMapper;

    @POST
    public Response insertUser(User user){
        userMapper.insertUser(user);
        return null;
    }

}
