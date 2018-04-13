/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ActionsPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
>>>>>>> 2109397bd934e266bf346ae8363292234acaedaf
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Guisao
 */
public class StudentPanel {
    
    public StudentPanel(){
         this.panel = new JPanel();
    }
    
    public JComponent show(){
        System.out.println("Displaying Student Page");
        panel.setPreferredSize(new Dimension(650, 300));
        panel.setLayout(new GridLayout(0,2));
        panel.setBackground(Color.WHITE);

        JButton labAcc = new JButton ("View Lab Accmodations");
        JButton labSchedule = new JButton ("View Lab Schedule");
        JButton labReserve = new JButton ("Reserve Lab");
        JButton labCancel = new JButton ("Cancel Lab");
        JButton labReservation = new JButton ("Lab Reservation");
        
        labAcc.setPreferredSize(new Dimension(100, 24));
        labSchedule.setPreferredSize(new Dimension(100, 24));
        labReserve.setPreferredSize(new Dimension(100, 24));
        labCancel.setPreferredSize(new Dimension(100, 24));
        
        panel.add(labAcc);
        panel.add(labSchedule);
        panel.add(labReserve);
        panel.add(labCancel);
        panel.add(labReservation);
        
        return panel;
    }
<<<<<<< HEAD
    
    private class ButtonClickListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
=======
>>>>>>> 2109397bd934e266bf346ae8363292234acaedaf
    private final transient JPanel panel;
}
