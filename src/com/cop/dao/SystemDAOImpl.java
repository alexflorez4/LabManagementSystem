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
    public boolean createUser(UserModel user) throws SystemCheckedException {

        try{
            em.persist(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public UserModel authenticateUserDao(UserModel user) throws SystemCheckedException {

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
    public boolean addLabDao(LabDetailsModel lab) throws SystemCheckedException {

        try{
            em.persist(lab);
            System.out.println("Lab has been added successfully");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteLabDao(LabDetailsModel lab) throws SystemCheckedException {

        try {
            em.remove(lab);
            return true;
        }catch (NoResultException nre){
            System.out.println("Lab " + lab.getId() + " was not found.");
            return false;
        }
    }
}
