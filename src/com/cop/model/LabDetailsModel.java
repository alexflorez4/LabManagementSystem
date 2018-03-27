package com.cop.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LabDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String location;

    @ElementCollection
    private List<String> accommodations;

    public LabDetailsModel() {
    }

    public LabDetailsModel(int id, String name, String location, List<String> accommodations) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.accommodations = accommodations;
    }

    /*public LabDetailsModel(String name, String location, List<String> accommodations) {
        //this.id = id;
        this.name = name;
        this.location = location;
        this.accommodations = accommodations;
    }*/

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

    public List<String> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<String> accommodations) {
        this.accommodations = accommodations;
    }
}
