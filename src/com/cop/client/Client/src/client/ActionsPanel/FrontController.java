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
public class FrontController {
    
    public FrontController(User user){

        dispatcher = new Dispatcher(user);
    }
    
    private boolean isAuthenticUser(){
        System.out.println("User is authenticated successfully.");
        return true;
    }
    
    private void trackRequest(String request){
      System.out.println("Page requested: " + request);
   }

   public JComponent dispatchRequest(String request){
      //log each request
      trackRequest(request);
      
      //authenticate the user
      if(isAuthenticUser()){
         
         return dispatcher.dispatch(request);
      }	
        return null;
   }
   
    private final Dispatcher dispatcher;
}
