package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.model.LabDetailsModel;
import com.cop.model.UserModel;

import java.util.List;


public interface LabService {

    public boolean addLabService(String type, LabDetailsModel lab) throws SystemCheckedException;

    public boolean deleteLabService(String userType, Integer labId) throws SystemCheckedException;

    public List<LabDetailsModel> getAllLabs() throws SystemCheckedException;

}
