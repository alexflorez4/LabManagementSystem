/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Carlos Guisao
 */
public class PanelFactory {
    
    public Panel GetPanel(String panel){
        
        if(panel == null)
        {
            return null;
        }
        else if(panel.equalsIgnoreCase("Info"))
        {
            return new GuiBasicInfoPanel();
        }
        else if(panel.equalsIgnoreCase("Action"))
        {
            return new GuiActionsPanel();
        }
        else if(panel.equalsIgnoreCase("Reserve"))
        {
            return new GuiUserReservationsPanel();
        }
        
        return null;
    }
}
