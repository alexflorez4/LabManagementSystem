/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.Login;

import client.model.User;

/**
 *
 * @author Carlos Guisao
 */
public class UserController {
    
    public UserController(User model, UserView view){
        this.model = model;
        this.view = view;
    }
    
    public void setId(int id){
        model.setId(id);
    }
    
    public int getId(){
        return model.getId();
    }
    
    public void setUserName(String name){
        model.setName(name);
    }
    
    public String getUserName(){
        return model.getName();
    }
    
    public void setType(String type){
        model.setType(type);
    }
    
    public String getType(){
        return model.getType();
    }
    
    public void updateView(){
        view.printUsersDetails(model.getId(), model.getName(), model.getType());
    }
    
    private final User model;
    private final UserView view;
}
