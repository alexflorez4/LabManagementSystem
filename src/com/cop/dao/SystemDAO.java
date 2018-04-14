package com.cop.dao;

import com.cop.model.LabDetailsModel;
import com.cop.model.LabSchedule;
import com.cop.model.UserModel;

import java.util.List;

public interface SystemDAO {

    public boolean createUser(UserModel user) throws SystemCheckedException;

    public UserModel authenticateUserDao(UserModel user) throws SystemCheckedException;

    public boolean addLabDao(LabDetailsModel lab) throws SystemCheckedException;

    public  boolean deleteLabDao(LabDetailsModel labId) throws SystemCheckedException;

    public LabDetailsModel viewLabAccDao(Integer labId) throws SystemCheckedException;

    public List<UserModel> getAllUsers() throws SystemCheckedException;

    public List<LabDetailsModel> getAllLabs() throws SystemCheckedException;

    public List<LabSchedule> viewLabScheduleDao(Integer labId) throws SystemCheckedException;

    public String makeReservationDao(LabSchedule ls) throws SystemCheckedException;
}
