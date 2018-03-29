/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class loginPanel {
    
    private JFrame mainFrame;
    private JPanel editorPanel;
    
    public void createMainLoginPanel(){
        mainFrame = new JFrame("FAU LMS");
        mainFrame.setPreferredSize(new Dimension(400, 300));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        
        editorPanel = new JPanel();
        editorPanel.add(getMainLoginPanel());
        content.add(editorPanel);
        
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
        
    public JComponent getMainLoginPanel() {

        JLabel loginTitle = new JLabel("Login");
        JButton submit = new JButton ("Submit");

        if (panel == null) {
            panel = new JPanel();
            panel.setPreferredSize(new Dimension(200, 150));
            loginTitle.setPreferredSize( new Dimension( 200, 24 ));
            submit.setPreferredSize(new Dimension(200, 24));
            nameField = new JTextField(name);
            relationField = new JTextField(relationship);
            panel.add(new JLabel(""));
            panel.add(new JLabel(""));
            panel.setLayout(new GridLayout(0,2));
            panel.add(loginTitle);
            panel.add(new JLabel(""));
            panel.add(new JLabel(""));
            panel.add(new JLabel(""));
            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Password:"));
            panel.add(relationField);
            panel.add(new JLabel(""));
            panel.add(new JLabel(""));
            panel.add(new JLabel(""));
            panel.add(submit);
        } else {
            nameField.setText(name);
            relationField.setText(relationship);
        }

        return panel;
    }
    
    private class WindowCloseManager extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent evt){
            exitApplication();
        }
    }
    
    private void exitApplication(){
        System.exit(0);
    }
    
    private transient JPanel panel;
    private transient JTextField nameField;
    private transient JTextField relationField;
    private String name;
    private String relationship;
    
}
