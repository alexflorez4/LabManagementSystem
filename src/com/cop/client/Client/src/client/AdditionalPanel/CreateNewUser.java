/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import static client.RESTCaller.callURL;
import client.model.User;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Guisao
 */
public class CreateNewUser implements FacadePanel{

    public CreateNewUser() {
        this.choices = new String[]{"Admin", "Student"};
    }

    @Override
    public void draw(User user){
        mainFrame = new JFrame("Create New User");
        mainFrame.setPreferredSize(new Dimension(400, 300));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        editorPanel = new JPanel();
        editorPanel.add(getMainPanel());
        content.add(editorPanel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public JComponent getMainPanel(){
        
        JLabel title = new JLabel("New User");
        JButton submit = new JButton ("Submit");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        title.setPreferredSize( new Dimension( 200, 50 ));
        submit.setPreferredSize(new Dimension(200, 24));
        nameField = new JTextField(location);
        usernameField = new JTextField(labName);
        passwordField = new JTextField(details);
        typeDropdown = new JComboBox<>(choices);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.setLayout(new GridLayout(0,2));
        panel.add(title);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.add(new JLabel("User Name"));
        panel.add(usernameField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.add(new JLabel("Type"));
        panel.add(typeDropdown);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        submit.setActionCommand("Submit");
        submit.addActionListener(new ButtonClickListener());
        panel.add(submit);
        
        return panel;
    }

    private class ButtonClickListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
            
            String command = e.getActionCommand();  
            if(command.equals("Submit") && addUser(e)){
                mainFrame.dispose();
            }
        }
    }
    
    private boolean addUser(ActionEvent e){
        
        String username =  usernameField.getText();
        String name = nameField.getText();
        String password = passwordField.getText();
        String type = (String) typeDropdown.getSelectedItem();
        
        String URL = callURL("http://localhost:8181/faulms/create/" 
                + username + "/" + name + "/" + password + "/" + type + "/");
        
        return Boolean.parseBoolean(URL);
    }
    
    private JFrame mainFrame;
    private JPanel editorPanel;
    private JPanel panel;
    private JTextField nameField;
    private JTextField usernameField;
    private JTextField passwordField;
    private String labName;
    private String location;
    private String details;
    private final String[] choices;
    JComboBox<String> typeDropdown;
}
