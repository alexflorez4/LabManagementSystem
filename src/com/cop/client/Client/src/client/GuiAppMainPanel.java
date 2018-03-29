/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Guisao
 */
public class GuiAppMainPanel {
    
    public void CreateMainPanel(){
        mainFrame = new JFrame("FAU LMS Dashboard");
        mainFrame.setPreferredSize(new Dimension(700, 650));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        GuiBasicInfoPanel basicInfoPanel = new GuiBasicInfoPanel();
        infoPanel = new JPanel();
        infoPanel.add(basicInfoPanel.createUserInfoPanel());
        mainFrame.add(infoPanel);
        
        GuiActionsPanel basicActionPanel = new GuiActionsPanel();
        actionPanel = new JPanel();
        actionPanel.add(basicActionPanel.GuiActionsPanel());
        mainFrame.add(actionPanel);
        
        GuiUserReservationsPanel basicDisplayReservations = new GuiUserReservationsPanel();
        displayPanel = new JPanel();
        displayPanel.add(basicDisplayReservations.displayUserReservations());
        mainFrame.add(displayPanel);
        
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    private JFrame mainFrame;
    private JPanel infoPanel;
    private JPanel actionPanel;
    private JPanel displayPanel;
    
    private class WindowCloseManager extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent evt){
            exitApplication();
        }
    }
    
    private void exitApplication(){
        System.exit(0);
    }
}
