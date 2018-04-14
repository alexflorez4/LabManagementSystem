package com.cop.service;

import com.cop.dao.SystemCheckedException;
import com.cop.dao.SystemDAO;
import com.cop.model.LabDetailsModel;
import com.cop.model.LabSchedule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public LabDetailsModel viewLabAccService(Integer labId) throws SystemCheckedException {
        return systemDAO.viewLabAccDao(labId);
    }

    @Override
    public List<LabSchedule> viewLabSchedService(Integer labId) throws SystemCheckedException {
        return systemDAO.viewLabScheduleDao(labId);
    }

    @Override
    public String makeReservationService(String userid, Integer labid, String resBegin, String resEnd) throws SystemCheckedException {

        //SAMPLE DATE:  String dateIn = "2018-4-18 9:00";
        java.text.SimpleDateFormat DATE_FORMAT_1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm");

        Date startReservation = new Date();
        Date endReservation = new Date();

        try {
            startReservation = DATE_FORMAT_1.parse(resBegin);
            endReservation = DATE_FORMAT_1.parse(resEnd);
        } catch (ParseException e) {
            System.out.println("Was not able to parse date");
            e.printStackTrace();
        }

        if(startReservation.after(endReservation)){
            throw  new SystemCheckedException("Reservation ends before starts");
        }

        LabSchedule ls = new LabSchedule(userid, labid, startReservation, endReservation);
        return systemDAO.makeReservationDao(ls);
    }
}
