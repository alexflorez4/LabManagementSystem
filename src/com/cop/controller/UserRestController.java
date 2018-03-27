package com.cop.controller;

import com.cop.dao.SystemCheckedException;
import com.cop.model.LabDetailsModel;
import com.cop.model.UserModel;
import com.cop.service.LabService;
import com.cop.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private LabService labService;


    @RequestMapping({"/create/{name}/{password}/{type}"})
    public boolean createUser(@PathVariable String name, @PathVariable String password, @PathVariable String type) throws SystemCheckedException {
        return userService.createUser(new UserModel(name,type,password));
    }

    @RequestMapping({"/user/{id}/{password}"})
    public UserModel userLoginController(@PathVariable Integer id, @PathVariable String password) throws SystemCheckedException {
        return this.userService.authenticateUser(new UserModel(id, password));
    }

    @RequestMapping({"/addlab/{userType}/{name}/{location}/{accommodations}"})
    public boolean addLabController(@PathVariable String userType, @PathVariable String name, @PathVariable String location, @PathVariable String accommodations)
            throws SystemCheckedException{

        if(StringUtils.isBlank(name) || StringUtils.isBlank(location)){
            throw new SystemCheckedException("Lab name and location cannot be empty");
        }

        if(StringUtil.isEmpty(userType)){
            throw new SystemCheckedException("User type cannot be empty");
        }

        List<String> labAccommodations = new ArrayList<>();

        if(StringUtils.isNotBlank(accommodations)){
            labAccommodations = Arrays.asList(StringUtils.split(accommodations, ","));
        }

        LabDetailsModel lab = new LabDetailsModel(0, name, location, labAccommodations);
        return this.labService.addLabService(userType, lab);
    }

    @RequestMapping({"/deletelab/{userType}/{labId}"})
    public boolean deleteLabController(@PathVariable String userType, @PathVariable Integer labId) throws SystemCheckedException{

        return this.labService.deleteLabService(userType, labId);
    }


}
