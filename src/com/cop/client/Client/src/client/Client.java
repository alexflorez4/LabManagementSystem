/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.MainPanel.GuiAppMainPanel;
import client.Login.loginPanel;

/**
 *
 * @author Carlos Guisao
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        loginPanel login = new loginPanel();
        login.createMainLoginPanel();
        
        GuiAppMainPanel MainDashboad = new GuiAppMainPanel();
        MainDashboad.CreateMainPanel();
        
    }
    
}
