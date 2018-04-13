package com.cop.dao;

import com.cop.model.LabDetailsModel;
import com.cop.model.LabSchedule;
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
    public LabDetailsModel viewLabAccDao(Integer labId) throws SystemCheckedException {
        Query q = em.createQuery("SELECT lm FROM LabDetailsModel lm WHERE lm.id = :labId");
        q.setParameter("labId", labId);
        try {
            return (LabDetailsModel) q.getSingleResult();
        }catch (NoResultException nr){
            throw new SystemCheckedException("No laboratory found with id " + labId);
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

    @Override
    public String makeReservationDao(LabSchedule ls) throws SystemCheckedException {

        //LABSCHEDULE(ID INTEGER NOT NULL PRIMARY KEY,
        // LABID INTEGER NOT NULL,
        // RESERVATIONEND TIMESTAMP,
        // RESERVATIONSTART TIMESTAMP,
        // USERID VARCHAR(255))

        //em.persist(ls);
        Query q = em.createNativeQuery("INSERT INTO LABSCHEDULE (ID, USERID, LABID, RESERVATIONSTART, RESERVATIONEND) VALUES (3, ?, ?, ?, ?)");
        q.setParameter(1, ls.getUserId());
        q.setParameter(2, ls.getLabId());
        q.setParameter(3, ls.getReservationStart());
        q.setParameter(4, ls.getReservationEnd());
        q.executeUpdate();
        //em.getTransaction().commit();
        return "Success";
        /*try {
            em.persist(ls);
            return "Success";
        }catch (Exception e){
            e.getMessage();
            return "Insertion failed";
        }*/
    }
}
