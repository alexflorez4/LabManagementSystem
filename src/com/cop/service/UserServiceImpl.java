package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.dao.SystemDAO;
import com.cop.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl implements UserService {

    private SystemDAO systemDAO;

    @Autowired
    public UserServiceImpl(SystemDAO systemDAO) {
        this.systemDAO = systemDAO;
    }

    @Override
    public void createUser(UserModel user) throws SystemCheckedException{
        systemDAO.createUser(user);
    }

    @Override
    public String authenticateUser(UserModel user) {
        System.out.println(user.getId() + " - " +  user.getPassword());
        return "user authenticated.";
    }
}
