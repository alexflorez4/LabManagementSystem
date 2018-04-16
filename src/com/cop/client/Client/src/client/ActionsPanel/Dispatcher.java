/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ActionsPanel;

import client.model.User;
import javax.swing.JComponent;

/**
 *
 * @author Carlos Guisao
 */
public class Dispatcher {
    
    public Dispatcher(User user){
        studentView = new StudentPanel(user);
        adminView = new AdminPanel(user);
    }
    
    public JComponent dispatch(String request){
        if(request.equalsIgnoreCase("STUDENT")){
            return studentView.show();
        }
        else{
            return adminView.show();
        }
    }
    
    private final StudentPanel studentView;
    private final AdminPanel adminView;
}
