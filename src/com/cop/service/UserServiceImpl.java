package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.dao.SystemDAO;
import com.cop.model.UserModel;
import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class UserServiceImpl implements UserService {

    private SystemDAO systemDAO;

    @Autowired
    public UserServiceImpl(SystemDAO systemDAO) {
        this.systemDAO = systemDAO;
    }

    @Override
    public boolean createUser(UserModel user) throws SystemCheckedException{

        if(StringUtil.isEmpty(user.getName()) || StringUtil.isEmpty(user.getPassword()) || StringUtil.isEmpty(user.getUserId())){
            throw new SystemCheckedException("name, user id and password cannot be empty");
        }
        if(user.getType().equalsIgnoreCase("admin") || user.getType().equalsIgnoreCase("student")){
            return systemDAO.createUser(user);
        }
        else{
            throw new SystemCheckedException("User type must be admin or student, not " + user.getType());
        }
    }

    @Override
    public UserModel authenticateUser(UserModel user) throws SystemCheckedException{
        UserModel userResult = systemDAO.authenticateUserDao(user);
        return new UserModel(userResult.getName(), userResult.getUserId(), userResult.getType());
    }

    @Override
    public List<UserModel> getAllUsers() throws SystemCheckedException {
        return systemDAO.getAllUsers();
    }
}
