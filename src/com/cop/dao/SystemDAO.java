package com.cop.dao;

import com.cop.model.LabDetailsModel;
import com.cop.model.UserModel;

public interface SystemDAO {

    public boolean createUser(UserModel user) throws SystemCheckedException;

    public UserModel authenticateUserDao(UserModel user) throws SystemCheckedException;

    public boolean addLabDao(LabDetailsModel lab) throws SystemCheckedException;

    public  boolean deleteLabDao(LabDetailsModel labId) throws SystemCheckedException;
}
