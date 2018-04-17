/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.client.AdditionalPanel;

import com.cop.client.model.User;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Guisao
 */
public class ViewLabSchedule implements FacadePanel{
    
    @Override
    public void draw(User user){
        mainFrame = new JFrame("Lab Accomodations");
        mainFrame.setPreferredSize(new Dimension(500, 500));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        editorPanel = new JPanel();
        editorPanel.add(getMainPanel());
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        editorPanel.add(getDetailPanel());
        content.add(editorPanel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public JComponent getMainPanel(){
        
        JLabel loginTitle = new JLabel("Lab");
        JButton submit = new JButton ("Submit");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        loginTitle.setPreferredSize( new Dimension( 200, 50 ));
        viewLabField = new JTextField(viewLab);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.setLayout(new GridLayout(0,2));
        panel.add(loginTitle);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Laboratory ID:"));
        panel.add(viewLabField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        submit.setActionCommand("Submit");
        panel.add(submit);
        
        return panel;
    }
    
     public JComponent getDetailPanel(){
        
        JLabel DetailTitle = new JLabel("Lab Schedule");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        DetailTitle.setPreferredSize( new Dimension( 300, 50 ));
        viewLabField = new JTextField(viewLab);
        panel.setBackground(Color.WHITE);
        
        return panel;
     }
    
    private JFrame mainFrame;
    private JPanel editorPanel;
    private JPanel panel;
    private JTextField viewLabField;
    private String viewLab;
}
