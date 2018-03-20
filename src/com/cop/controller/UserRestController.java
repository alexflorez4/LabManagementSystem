package com.cop.controller;

import com.cop.dao.SystemCheckedException;
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

    @RequestMapping({"/create/{name}/{password}/{type}"})
    public void createUser(@PathVariable String name, @PathVariable String password, @PathVariable String type) throws SystemCheckedException {
        userService.createUser(new UserModel(name,type,password));
    }

    @RequestMapping({"/user/{id}/{password}"})
    public UserModel userLoginController(@PathVariable Integer id, @PathVariable String password) throws SystemCheckedException {
        return this.userService.authenticateUser(new UserModel(id, password));
    }
}
