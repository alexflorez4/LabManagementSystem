package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.dao.SystemDAO;
import com.cop.model.LabDetailsModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LabServiceImpl implements LabService {

    private SystemDAO systemDAO;

    @Autowired
    public LabServiceImpl(SystemDAO systemDAO) {
        this.systemDAO = systemDAO;
    }

    @Override
    public boolean addLabService(String type, LabDetailsModel lab) throws SystemCheckedException {

        if(type.equalsIgnoreCase("admin")){
            return systemDAO.addLabDao(lab);
        }else{
            throw new SystemCheckedException("User type is not allowed to perform add operation");
        }
    }

    @Override
    public boolean deleteLabService(String userType, Integer labId) throws SystemCheckedException {

        if (StringUtils.isBlank(userType) || !userType.equalsIgnoreCase("admin")){
            throw  new SystemCheckedException("User type is not allowed to perform delete operation");
        }
        LabDetailsModel ldm = new LabDetailsModel(labId, "", "", null);
        return systemDAO.deleteLabDao(ldm);
    }

    @Override
    public List<LabDetailsModel> getAllLabs() throws SystemCheckedException {
        return systemDAO.getAllLabs();
    }
}
