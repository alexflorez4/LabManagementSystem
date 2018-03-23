package com.cop.dao;

import com.cop.model.LabDetailsModel;
import com.cop.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class SystemDAOImpl implements SystemDAO {

    private final String AUTH_USER = "SELECT um FROM UserModel as um WHERE um.id=:userId AND um.password=:userPassword";

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createUser(UserModel user) throws SystemCheckedException {

        if(user.getType().equalsIgnoreCase("admin") || user.getType().equalsIgnoreCase("student"))
            em.persist(user);
        else
            throw new SystemCheckedException("User type must be admin or student, not" + user.getType());
    }

    @Override
    public UserModel authenticateUserDao(UserModel user) throws SystemCheckedException {

        System.out.println("In " + this.getClass().toString());
        System.out.println(user.toString());

        try {
            Query q = em.createQuery(AUTH_USER);
            q.setParameter("userId", user.getId());
            q.setParameter("userPassword", user.getPassword());
            UserModel result = (UserModel) q.getSingleResult();
            return result;
        }catch (NoResultException re){
            throw new SystemCheckedException("User id or password is incorrect");
        }
    }

    @Override
    public String addLabDao(LabDetailsModel lab) throws SystemCheckedException {

        em.persist(lab);
        return "Lab added successfully";
    }
}
