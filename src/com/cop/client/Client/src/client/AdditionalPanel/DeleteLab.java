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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Guisao
 */
public class DeleteLab implements FacadePanel{
    
    @Override
    public void draw(User user){
        mainFrame = new JFrame("Delete Lab");
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
        
        JLabel loginTitle = new JLabel("Delete Lab");
        JButton submit = new JButton ("Submit");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        loginTitle.setPreferredSize( new Dimension( 200, 50 ));
        submit.setPreferredSize(new Dimension(200, 24));
        deleteField = new JTextField(delete);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.setLayout(new GridLayout(0,2));
        panel.add(loginTitle);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Laboratory ID:"));
        panel.add(deleteField);
        
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
            if(command.equals("Submit") && deleteLab()){
                mainFrame.dispose();
            }
        }

        private boolean deleteLab() {
            String lab =  deleteField.getText();

            String URL = callURL("http://localhost:8181/faulms/deletelab/admin/"+ lab);
            System.out.println("\n============Output:============ \n" + URL);

            return Boolean.parseBoolean(URL);
        }
    }
    
    private JFrame mainFrame;
    private JPanel editorPanel;
    private JPanel panel;
    private JTextField deleteField;
    private String delete;
}
