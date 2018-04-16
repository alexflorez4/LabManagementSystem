/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import java.util.List;

/**
 *
 * @author Carlos Guisao
 */
public class LabDetails {
    
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
    
    @Override
    public String toString() {
        return id + ", name=" + name  + "\t" + 
                ", location='" + location + '\'' +
                ", accommodations=" + accommodations;
    }
    
    private int id;
    private String name;
    private String location;
    private List<String> accommodations;
}
