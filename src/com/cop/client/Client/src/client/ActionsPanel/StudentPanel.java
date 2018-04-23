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
public class StudentPanel {
    
    public StudentPanel(User user){
         this.panel = new JPanel();
         this.user = user;
    }
    
    public JComponent show(){
        System.out.println("Displaying Student Page");
        panel.setPreferredSize(new Dimension(650, 300));
        panel.setLayout(new GridLayout(0,2));
        panel.setBackground(Color.WHITE);

        JButton labAcc = new JButton ("View Lab Accmodations");
        JButton labSchedule = new JButton ("View Lab Schedule");
        JButton labReserve = new JButton ("Reserve Lab");
        JButton labCancel = new JButton ("Cancel Reservation");
        
        labAcc.setPreferredSize(new Dimension(100, 24));
        labSchedule.setPreferredSize(new Dimension(100, 24));
        labReserve.setPreferredSize(new Dimension(100, 24));
        labCancel.setPreferredSize(new Dimension(100, 24));
        
        panel.add(labAcc);
        panel.add(labSchedule);
        panel.add(labReserve);
        panel.add(labCancel);
        
        labAcc.setActionCommand("View Lab Accmodations");
        labSchedule.setActionCommand("View Lab Schedule");
        labReserve.setActionCommand("Reserve Lab");
        labCancel.setActionCommand("Cancel Reservation");
        
        labAcc.addActionListener(new StudentPanel.ButtonClickListener());
        labSchedule.addActionListener(new StudentPanel.ButtonClickListener());
        labReserve.addActionListener(new StudentPanel.ButtonClickListener());
        labCancel.addActionListener(new StudentPanel.ButtonClickListener());
        
        return panel;
    }
    
    private class ButtonClickListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
            PanelMaker panelMaker = new PanelMaker(user);
            
          switch (command) {
              case "View Lab Accmodations":
                  panelMaker.drawViewLabAcc();
                  break;
              case "View Lab Schedule":
                  panelMaker.drawViewLabSch();
                  break;
              case "Reserve Lab":
                  panelMaker.drawMakeReservation();
                  break;
              case "Cancel Reservation":
                  panelMaker.drawCancelRervation();
                  break;
              default:
                  break;
          }
        }
    }
    
    private final transient JPanel panel;
    private final User user;
}
