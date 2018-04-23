/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import static client.RESTCaller.callURL;
import client.model.LabDetails;
import client.model.User;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Guisao
 */
public class ViewLabSchedule implements FacadePanel, ActionListener{

    public ViewLabSchedule() {
        this.mainFrame = new JFrame("Lab Accomodations");
        this.editorPanel = new JPanel();
        this.panel = new JPanel();
        this.panel2 = new JPanel();
        this.labs = new DefaultListModel();
        this.labList = new JList(labs);
        this.labListScrollPane = new JScrollPane(labList);
        this.viewLabField = new JTextField(viewLab);
    }
    
    @Override
    public void draw(User user){
        
        mainFrame.setPreferredSize(new Dimension(500, 500));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        editorPanel.add(getMainPanel());
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        editorPanel.add(getDetailPanel());
        content.add(editorPanel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public JComponent getMainPanel() {
        
        JLabel loginTitle = new JLabel("Lab");
        JButton submit = new JButton ("Submit");
        
        panel.setPreferredSize(new Dimension(200, 200));
        loginTitle.setPreferredSize( new Dimension( 200, 50 ));
        
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
        
        //submit.addActionListener(new ButtonClickListener());
        submit.addActionListener(this);
        
        submit.setActionCommand("Submit");
        panel.add(submit);
        
        return panel;
    }
    
    public JComponent getDetailPanel(){
        
        JLabel DetailTitle = new JLabel("Lab Detail");

        panel2.setPreferredSize(new Dimension(300, 200));
        DetailTitle.setPreferredSize( new Dimension( 300, 50 ));
        panel2.setBackground(Color.WHITE);
        return panel2;
     }
     
    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();  
        if(command.equals("Submit")){
            if(labListScrollPane != null)
                panel2.remove(labListScrollPane);
            panel2.add(viewAccomation());
            panel2.revalidate();
        }
        
    }
    
    private JScrollPane viewAccomation() {
        
        String labID =  viewLabField.getText();
        String URL = callURL("http://localhost:8181/faulms/viewlabAcc/"+ labID);
        System.out.println("\n============Output:============ \n" + URL);

        try {

        org.codehaus.jackson.map.ObjectMapper mapper = new org.codehaus.jackson.map.ObjectMapper();
        lab = mapper.readValue(URL, LabDetails.class);
        System.out.println("User = " + lab);

        System.out.println("user.getName() = " + lab.getAccommodations());

        lab.getAccommodations().forEach((loopLab) -> {
            labs.addElement(loopLab);
            });
        
        labListScrollPane.setPreferredSize(new Dimension(300, 200));

        } catch (IOException e) {
            return labListScrollPane;
        }
        
        return labListScrollPane;
    }
     
    private final JFrame mainFrame;
    private final JPanel editorPanel;
    private final JPanel panel;
    private final JPanel panel2;;
    private final JScrollPane labListScrollPane;
    private final JTextField viewLabField;
    private final JList labList;
    private final DefaultListModel labs;
    private String viewLab;
    private LabDetails lab;
}
