package com.cop.controller;

import com.cop.model.UserModel;
import com.cop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/user/{id}/{password}"})
    public String userLoginController(@PathVariable String id, @PathVariable String password){
        return this.userService.authenticateUser(new UserModel(id, password));
    }
}
