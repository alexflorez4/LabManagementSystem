package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.model.LabDetailsModel;
import com.cop.model.UserModel;


public interface LabService {

    public String addLabService(String type, LabDetailsModel lab) throws SystemCheckedException;

}
