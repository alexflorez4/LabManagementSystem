/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ActionsPanel;

import client.AdditionalPanel.PanelMaker;
import client.model.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Guisao
 */
public class AdminPanel {
    
    public AdminPanel(User user){
         this.panel = new JPanel();
         this.user = user;
    }
    
    public JComponent show(){
        
        System.out.println("Displaying User");
        panel.setPreferredSize(new Dimension(650, 300));
        panel.setLayout(new GridLayout(0,2));
        panel.setBackground(Color.WHITE);

        JButton addLab = new JButton ("Add Lab");
        JButton deleteLab = new JButton ("Delete Lab");
        JButton viewLabAcc = new JButton ("View Lab Accomodations");
        JButton labCancel = new JButton ("Cancel Lab");
        JButton viewUsers = new JButton ("View Users");
        JButton createNewUser = new JButton ("Create New User");
        
        addLab.setPreferredSize(new Dimension(100, 24));
        deleteLab.setPreferredSize(new Dimension(100, 24));
        viewLabAcc.setPreferredSize(new Dimension(100, 24));
        labCancel.setPreferredSize(new Dimension(100, 24));
        
        addLab.setActionCommand("Add Lab");
        deleteLab.setActionCommand("Delete Lab");
        viewLabAcc.setActionCommand("View Lab Accomodations");
        labCancel.setActionCommand("Cancel Lab");
        viewUsers.setActionCommand("View Users");
        createNewUser.setActionCommand("Create New User");
        
        addLab.addActionListener(new AdminPanel.ButtonClickListener());
        deleteLab.addActionListener(new AdminPanel.ButtonClickListener());
        viewLabAcc.addActionListener(new AdminPanel.ButtonClickListener());
        labCancel.addActionListener(new AdminPanel.ButtonClickListener());
        viewUsers.addActionListener(new AdminPanel.ButtonClickListener());
        createNewUser.addActionListener(new AdminPanel.ButtonClickListener());
        
        panel.add(addLab);
        panel.add(deleteLab);
        panel.add(viewLabAcc);
        panel.add(labCancel);
        panel.add(viewUsers);
        panel.add(createNewUser);
        
        return panel;
    }
    
    private class ButtonClickListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
            PanelMaker panelMaker = new PanelMaker(user);

            switch (command) {
              case "Add Lab":
                  panelMaker.drawAddLab();
                  break;
              case "Delete Lab":
                  panelMaker.drawDeleteLab();
                  break;
              case "View Lab Accomodations":
                  panelMaker.drawViewLabAcc();
                  break;
              case "Cancel Lab":
                  panelMaker.drawCancelLab();
                  break;
              case "View Users":
                  panelMaker.drawViewAllUsers();
                  break;
              case "Create New User":
                  panelMaker.drawCreateNewUser();
                  break;
              default:
                  break;
          }
        }
    }
    
    private final transient JPanel panel;
    private final User user;
}
