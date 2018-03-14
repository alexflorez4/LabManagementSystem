package com.cop.dao;

import com.cop.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SystemDAOImpl implements SystemDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createUser(UserModel user) throws SystemCheckedException {

        if(user.getType().equalsIgnoreCase("admin") || user.getType().equalsIgnoreCase("student"))
            em.persist(user);
        else
            throw new SystemCheckedException("User type must be admin or student, not" + user.getType());
    }
}
