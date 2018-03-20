package com.cop.dao;

import com.cop.model.UserModel;

public interface SystemDAO {

    public void createUser(UserModel user) throws SystemCheckedException;

    public UserModel authenticateUserDao(UserModel user) throws SystemCheckedException;
}
