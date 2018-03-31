/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ActionsPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Guisao
 */
public class AdminPanel {
    
    public AdminPanel(){
         this.panel = new JPanel();
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
        JButton labReservation = new JButton ("Lab Reservation");
        
        addLab.setPreferredSize(new Dimension(100, 24));
        deleteLab.setPreferredSize(new Dimension(100, 24));
        viewLabAcc.setPreferredSize(new Dimension(100, 24));
        labCancel.setPreferredSize(new Dimension(100, 24));
        
        panel.add(addLab);
        panel.add(deleteLab);
        panel.add(viewLabAcc);
        panel.add(labCancel);
        panel.add(labReservation);
        
        return panel;
    }
    
    private final transient JPanel panel;
}
