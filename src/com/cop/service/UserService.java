package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.model.UserModel;

public interface UserService {

    public void createUser(UserModel user)  throws SystemCheckedException;

    public UserModel authenticateUser(UserModel user) throws SystemCheckedException;
}
