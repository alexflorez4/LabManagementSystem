/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Carlos Guisao
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    private int id;
    private String name;
    private String type;
    private String password;
    private String userId;
}
