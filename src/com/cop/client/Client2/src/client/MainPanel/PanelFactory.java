/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.MainPanel;

import client.model.User;


/**
 *
 * @author Carlos Guisao
 */
public class PanelFactory {
    
    public Panel GetPanel(String panel, User user){
        
        if(panel == null)
        {
            return null;
        }
        else if(panel.equalsIgnoreCase("Info"))
        {
            return new GuiBasicInfoPanel(user);
        }
        else if(panel.equalsIgnoreCase("Action"))
        {
            return new GuiActionsPanel(user);
        }
        else if(panel.equalsIgnoreCase("Reserve"))
        {
            return new GuiUserReservationsPanel(user);
        }
        
        return null;
    }
}
