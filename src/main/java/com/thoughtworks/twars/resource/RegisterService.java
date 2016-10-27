package com.thoughtworks.twars.resource;


import com.thoughtworks.twars.bean.User;
import com.thoughtworks.twars.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("register")
@Api
public class RegisterService {
    @Inject
    private UserMapper userMapper;

    @POST
    @ApiResponses(value = {@ApiResponse(code = 200, message = "register successfully")})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertUser(User user) {
        userMapper.insertUser(user);

        Map<String, Object> map = new HashMap<>();
        Map<String, String> userInfo = new HashMap<>();
        Map<String, String> theUser = new HashMap<>();

        map.put("id", user.getId());
        userInfo.put("uri", "userInfo/" + user.getId());
        theUser.put("uri", "user/" + user.getId());

        map.put("userInfo", userInfo);
        map.put("user", theUser);

        return Response.status(Response.Status.OK).entity(map).build();
    }

}
