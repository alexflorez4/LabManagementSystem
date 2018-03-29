package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.model.UserModel;

import java.util.List;

public interface UserService {

    public boolean createUser(UserModel user)  throws SystemCheckedException;

    public UserModel authenticateUser(UserModel user) throws SystemCheckedException;

    public List<UserModel> getAllUsers() throws SystemCheckedException;
}
