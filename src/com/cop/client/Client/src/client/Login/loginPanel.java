/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.Login;

import client.MainPanel.GuiAppMainPanel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Guisao
 */
public final class loginPanel {
    
    public loginPanel(){
        createMainLoginPanel();
    }
    
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

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 150));
        loginTitle.setPreferredSize( new Dimension( 200, 24 ));
        submit.setPreferredSize(new Dimension(200, 24));
        nameField = new JTextField(name);
        passwordField = new JPasswordField(relationship);
        
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
        panel.add(passwordField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        submit.setActionCommand("Submit");
        submit.addActionListener(new ButtonClickListener());
        panel.add(submit);
        
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
    
    private boolean authenticateUser(){
        return true;
    }
    
    public static User retrieveUser(){
        User user = new User();
        user.setId(1);
        user.setName("Carlos");
        user.setType("Admin");
        return user;
    }
    
    private class ButtonClickListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {

            String command = e.getActionCommand();  
            if(command.equals("Submit")){
                mainFrame.dispose();
                GuiAppMainPanel MainDashboad = new GuiAppMainPanel();
                MainDashboad.CreateMainPanel();
            }
        }
      }
    
    private  JFrame mainFrame;
    private JPanel editorPanel;
    private JPanel panel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private String name;
    private String relationship;
    
}
