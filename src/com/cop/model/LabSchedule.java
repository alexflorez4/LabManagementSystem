package com.cop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LabSchedule {

    public LabSchedule() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String userId;

    private int labId;

    //@Column (name="DATE_CREATED")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date reservationStart;

    //@Column (name="DATE_END")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date reservationEnd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public Date getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(Date reservationStart) {
        this.reservationStart = reservationStart;
    }

    public Date getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Date reservationEnd) {
        this.reservationEnd = reservationEnd;
    }
}
