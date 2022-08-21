package com.kshitizprod.app.ws.mobileappws.controller;

import com.kshitizprod.app.ws.mobileappws.service.UserService;
import com.kshitizprod.app.ws.mobileappws.shared.dto.UserDto;
import com.kshitizprod.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.kshitizprod.app.ws.mobileappws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}",
            produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String id){
        UserRest returnValue=new UserRest();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto,returnValue);
        return returnValue;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)throws Exception{

        if(userDetails.getFirstName().isEmpty()) throw new NullPointerException("The object is null.");
        UserRest returnValue=new UserRest();

        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);

        UserDto createdUser= userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return returnValue;
    }

    @PutMapping
    public String updateUser()
    {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
