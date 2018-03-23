package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.dao.SystemDAO;
import com.cop.model.LabDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LabServiceImpl implements LabService {

    private SystemDAO systemDAO;

    @Autowired
    public LabServiceImpl(SystemDAO systemDAO) {
        this.systemDAO = systemDAO;
    }

    @Override
    public String addLabService(String type, LabDetailsModel lab) throws SystemCheckedException {

        if(!type.equalsIgnoreCase("admin")){
            throw new SystemCheckedException("User not allowed to add laboratory");
        }
        return systemDAO.addLabDao(lab);
    }
}
