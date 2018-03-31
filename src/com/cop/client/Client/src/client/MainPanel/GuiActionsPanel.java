/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.MainPanel;

import client.ActionsPanel.FrontController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Guisao
 */
public class GuiActionsPanel implements Panel{

    public GuiActionsPanel() {
        this.panel = new JPanel();
    }
    
    @Override
    public JComponent GetPanel(int x, int y){

        FrontController front = new FrontController();
        
        //panel = (JPanel)front.dispatchRequest("ADMIN");
        panel = (JPanel)front.dispatchRequest("STUDENT");

        return panel;
    }
    
    private transient JPanel panel;
}
