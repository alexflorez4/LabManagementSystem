package com.cop.dao;

import com.cop.model.LabDetailsModel;
import com.cop.model.UserModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class SystemDAOImpl implements SystemDAO {


    private final String DELETE_LAB_ACC = "DELETE FROM LABDETAILSMODEL_ACCOMMODATIONS WHERE LabDetailsModel_id = :labId";
    private final String DELETE_LAB = "DELETE FROM LABDETAILSMODEL WHERE ID = :labId";

    @PersistenceContext(type= PersistenceContextType.EXTENDED)
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
            Query q = em.createQuery("SELECT um FROM UserModel um WHERE um.userId = :userId AND um.password = :userPassword");
            q.setParameter("userId", user.getUserId());
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
            Query q = em.createQuery("SELECT ld FROM LabDetailsModel ld WHERE ld.id = :labId");
            q.setParameter("labId", lab.getId());
            System.out.println(q.toString());
            LabDetailsModel ld = (LabDetailsModel) q.getSingleResult();

            System.out.println("Lab to be removed: " + ld.getId() + " " + ld.getName());
            em.remove(ld);

            /*LabDetailsModel detailsModel = em.merge(lab);
            em.remove(detailsModel);*/
            return true;
        }catch (NoResultException nre){
            System.out.println("Lab " + lab.getId() + " was not found.");
            return false;
        }
    }


    @Override
    public List<UserModel> getAllUsers() throws SystemCheckedException {
        List<UserModel> users = new ArrayList<>();
        Query q = em.createQuery("SELECT um FROM UserModel um");
        users = q.getResultList();
        return users;
    }

    @Override
    public List<LabDetailsModel> getAllLabs() throws SystemCheckedException {
        List<LabDetailsModel> labs = new ArrayList<>();
        Query q = em.createQuery("SELECT lm FROM LabDetailsModel lm");
        labs = q.getResultList();
        return labs;
    }
}
