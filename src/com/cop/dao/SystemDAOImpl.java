package com.cop.dao;

import com.cop.model.LabDetailsModel;
import com.cop.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class SystemDAOImpl implements SystemDAO {

    private final String AUTH_USER = "SELECT um FROM UserModel as um WHERE um.id=:userId AND um.password=:userPassword";
    private final String DELETE_LAB_ACC = "DELETE FROM LABDETAILSMODEL_ACCOMMODATIONS WHERE LabDetailsModel_id = :labId";
    private final String DELETE_LAB = "DELETE FROM LABDETAILSMODEL WHERE ID = :labId";
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
            /*Query q = em.createNativeQuery(DELETE_LAB_ACC);
            q.setParameter("labId", lab.getId());
            q.executeUpdate();

            Query q2 = em.createNativeQuery(DELETE_LAB);
            q2.setParameter("labId", lab.getId());
            q.executeUpdate();

            Query q3 = em.createQuery("select dm from LABDETAILSMODEL dm");

            List<LabDetailsModel> labs =  q3.getResultList();
            System.out.println("Current labs: " + labs.toString());
            return true;*/


            em.merge(lab);
            return true;

        }catch (NoResultException nre){
            System.out.println("Lab " + lab.getId() + " was not found.");
            return false;
        }
    }
}
