/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.MainPanel;

import client.ActionsPanel.FrontController;
import client.model.User;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Guisao
 */
public class GuiActionsPanel implements Panel{

    public GuiActionsPanel(User user) {
        this.panel = new JPanel();
        this.user = user;
    }
    
    @Override
    public JComponent GetPanel(int x, int y){

        FrontController front = new FrontController(user);

        panel = (JPanel)front.dispatchRequest(user.getType());

        return panel;
    }
    
    private transient JPanel panel;
    private final User user;
}