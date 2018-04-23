/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import client.MainPanel.GuiUserReservationsPanel;
import static client.RESTCaller.callURL;
import client.model.LabDetails;
import client.model.Schedule;
import client.model.TableLabModel;
import client.model.TableScheduleModel;
import client.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Carlos Guisao
 */
public class ViewLabSchedule implements FacadePanel, ActionListener{

    public ViewLabSchedule() {
        this.mainFrame = new JFrame();
        this.editorPanel = new JPanel();
        this.panel = new JPanel();
        this.panel2 = new JPanel();
        this.panel3 = new JPanel();
    }
    
    @Override
    public void draw(User user){
        mainFrame = new JFrame("Lab Schedule");
        mainFrame.setPreferredSize(new Dimension(900, 600));
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
        
        submit.addActionListener(this);
        
        submit.setActionCommand("Submit");
        panel.add(submit);
        
        return panel;
    }
    
     public JComponent getDetailPanel(){
        
        JLabel DetailTitle = new JLabel("Schedule Detail");

        panel2.setPreferredSize(new Dimension(800, 300));
        DetailTitle.setPreferredSize( new Dimension( 300, 50 ));
        panel2.setBackground(Color.WHITE);
        return panel2;
     }
     
    @Override
     public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();  
        if(command.equals("Submit")){
            if(scrollPane != null)
                panel3.remove(scrollPane);
            panel2.add(GetPanel());
            panel2.revalidate();
        }
        
    }
     
     public JComponent GetPanel(){

        panel3.setPreferredSize(new Dimension(800, 300));
        panel3.setLayout(new GridLayout(0,1));
        panel3.setBackground(Color.WHITE);
        
        String lab = viewLabField.getText();
        
    	TypeReference<List<Schedule>> mapType = new TypeReference<List<Schedule>>() {};
    	List<Schedule> jsonToPersonList = null;
        String URL = "http://localhost:8181/faulms/viewlabRes/" + lab + "/";
        jsonToPersonList = JSonList(jsonToPersonList, mapType, URL);
        
        panel3.setBorder (BorderFactory.createTitledBorder 
                
        (BorderFactory.createEtchedBorder (), "Schedule", TitledBorder.CENTER, TitledBorder.TOP, 
                new Font("times new roman",Font.BOLD,20)));

        table = new JTable();
        table.setRowHeight(30);
        TableScheduleModel model = new TableScheduleModel(jsonToPersonList);
        scrollPane = new JScrollPane(table);
        table.setModel(model);
        panel3.add(scrollPane);

        //panel.setLayout(new GridLayout(0,1));
        //panel.setBackground(Color.WHITE);

        return panel3;
    }
    
    public static List<Schedule> JSonList(List<Schedule> jsonToPersonList
            , TypeReference<List<Schedule>> mapType, String URL) {
        
        ObjectMapper objectMapper = new ObjectMapper();
        URL = callURL(URL);
        System.out.println("\n============Output:============ \n" + URL);
        try {
            jsonToPersonList = objectMapper.readValue(URL, mapType);
        } catch (IOException ex) {
            Logger.getLogger(GuiUserReservationsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonToPersonList;
    }
     
    private JFrame mainFrame;
    private final JPanel editorPanel;
    private JPanel panel;
    private final JPanel panel2;
    private final JPanel panel3;
    private JTextField viewLabField;
    private String viewLab;
    JScrollPane labListScrollPane;
    JTable table;
    JScrollPane scrollPane;
}
