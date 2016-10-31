package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.UserDetail;
import com.thoughtworks.twars.mapper.UserMapper;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.twars.bean.User;

@Path("user")
public class UserService {
    @Inject
    private UserMapper userMapper;

    @GET
    @Path("/{param}")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "get one user successfully"),
            @ApiResponse(code = 404,message = "get one user by id failed")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
            @ApiParam(name = "id",value = "int",required = true)
            @PathParam("param") int id){
        User user = userMapper.getUserById(id);
        if(user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("email", user.getEmail());
        map.put("mobilePhone", user.getMobilePhone());
        map.put("role", user.getRole());

        return Response.status(Response.Status.OK).entity(map).build();
    }


    @GET
    @Path("/mobilePhone/{param}")
    @ApiResponses(value = {@ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 404, message = "get one user failed")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByMobilePhone(
            @ApiParam(name = "mobilePhone", value = "String", required = true)
            @PathParam("param") String mobilePhone) {

        User user = userMapper.getUserByMobilePhone(mobilePhone);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("mobilePhone", user.getMobilePhone());
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        map.put("role", user.getRole());

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @GET
    @Path("/email/{param}")
    @ApiResponses(value = {@ApiResponse(code=200, message = "get one user successful"),
            @ApiResponse(code = 404, message = "get one user failed")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByEmail(
        @ApiParam(name = "email", value = "String" ,required = true)
        @PathParam("param") String email){
            User user = userMapper.getUserByEmail(email);


        if(user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map<String,Object> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("mobilePhone", user.getMobilePhone());
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        map.put("role", user.getRole());

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @GET
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get one userDetail successful"),
            @ApiResponse(code = 404, message = "get one userDetail user failed")})
    @Path("/{param}/detail")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDetail(
            @io.swagger.annotations.ApiParam(name = "userId", value = "int", required = true)
            @PathParam("param") int userId) {

        UserDetail detail = userMapper.getUserDetailById(userId);
        User user = userMapper.getUserById(userId);

        if (null == user || null == detail) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("userId", detail.getUserId());
        map.put("school", detail.getSchool());
        map.put("major", detail.getMajor());
        map.put("degree", detail.getDegree());
        map.put("name", detail.getName());
        map.put("gender", detail.getGender());
        map.put("email", user.getEmail());
        map.put("mobilePhone", user.getMobilePhone());
        map.put("schoolProvince",detail.getSchoolProvince());
        map.put("schoolCity", detail.getSchoolCity());
        map.put("entranceYear", detail.getEntranceYear());

        return Response.status(Response.Status.OK).entity(map).build();
    }
}
