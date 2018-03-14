package com.cop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LabDetailsModel {

    @Id
    private int id;

    private String name;
    private String location;

    public LabDetailsModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
