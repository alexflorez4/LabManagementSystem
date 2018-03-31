/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ActionsPanel;

import javax.swing.JComponent;

/**
 *
 * @author Carlos Guisao
 */
public class Dispatcher {
    
    public Dispatcher(){
        studentView = new StudentPanel();
        adminView = new AdminPanel();
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
