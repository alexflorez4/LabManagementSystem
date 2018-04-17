/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import static client.RESTCaller.callURL;
import client.model.User;
import com.google.common.base.Strings;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class AddLab implements FacadePanel{
    
    @Override
    public void draw(User user){
        mainFrame = new JFrame("Add Lab");
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
        
        JLabel loginTitle = new JLabel("Add Lab");
        JButton submit = new JButton ("Submit");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        loginTitle.setPreferredSize( new Dimension( 200, 50 ));
        submit.setPreferredSize(new Dimension(200, 24));
        locationField = new JTextField(location);
        labNameField = new JTextField(labName);
        detailsField = new JTextField(details);
        detailsField1 = new JTextField(details1);
        detailsField2 = new JTextField(details2);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.setLayout(new GridLayout(0,2));
        panel.add(loginTitle);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Location:"));
        panel.add(locationField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.add(new JLabel("Lab Name:"));
        panel.add(labNameField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.add(new JLabel("Details:"));
        panel.add(detailsField);
        
        panel.add(new JLabel(""));
        
        panel.add(detailsField1);
        
        panel.add(new JLabel(""));
        panel.add(detailsField2);
        
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
            if(command.equals("Submit") && addLab()){
                mainFrame.dispose();
            }
        }
    }
    
    private boolean addLab(){
        
        String lab =  labNameField.getText();
        String loc = locationField.getText();
        String detail = getDetails();
        
        String URL = callURL("http://localhost:8181/faulms/addlab/admin/"+ lab + "/" + loc + "/" + detail);
        System.out.println("\n============Output:============ \n" + URL);
        
        return Boolean.parseBoolean(URL);
    }
    
    private String getDetails() {
        
        String det1 = detailsField.getText();
        String det12 = detailsField1.getText();
        String det13 = detailsField2.getText();
        
        
        if(!Strings.isNullOrEmpty(det1) && !Strings.isNullOrEmpty(det12) && !Strings.isNullOrEmpty(det13)){
            return det1 + ",%20" + det12 + ",%20" + det13;
        }
        else if(!Strings.isNullOrEmpty(det1) && !Strings.isNullOrEmpty(det12)){
            return det1 + ",%20" + det12;
        }
        else if(!Strings.isNullOrEmpty(det1)){
            return det1;
        }
        
        return null;
        
    }
    
    private JFrame mainFrame;
    private JPanel editorPanel;
    private JPanel panel;
    private JTextField locationField;
    private JTextField labNameField;
    private JTextField detailsField;
    private JTextField detailsField1;
    private JTextField detailsField2;
    private String labName;
    private String location;
    private String details;
    private String details1;
    private String details2;
}
