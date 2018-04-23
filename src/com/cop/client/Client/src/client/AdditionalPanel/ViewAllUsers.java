/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import client.MainPanel.GuiUserReservationsPanel;
import static client.RESTCaller.callURL;
import client.model.TableUserModel;
import client.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Carlos Guisao
 */
public class ViewAllUsers implements FacadePanel{

    @Override
    public void draw(User user) {
        this.panel = new JPanel();
        mainFrame = new JFrame("View All Users");
        mainFrame.setPreferredSize(new Dimension(500, 400));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        editorPanel = new JPanel();
        GetPanel(500, 400);
        content.add(editorPanel);
        mainFrame.add(panel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public JComponent GetPanel(int x, int y){

        panel.setPreferredSize(new Dimension(x, y));
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.WHITE);

    	TypeReference<List<User>> mapType = new TypeReference<List<User>>() {};
    	List<User> jsonToPersonList = null;
        String URL = "http://localhost:8181/faulms/getAllUsers/";
        jsonToPersonList = JSonList(jsonToPersonList, mapType, URL);
        
        panel.setBorder (BorderFactory.createTitledBorder 
                
        (BorderFactory.createEtchedBorder (), "All Users", TitledBorder.CENTER, TitledBorder.TOP, 
                new Font("times new roman",Font.BOLD,20)));

        JTable table = new JTable();
        table.setRowHeight(30);
        TableUserModel model = new TableUserModel(jsonToPersonList);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setModel(model);
        panel.add(scrollPane);

        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.WHITE);

        return panel;
    }
    
    public static List<User> JSonList(List<User> jsonToPersonList
            , TypeReference<List<User>> mapType, String URL) {
        
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
    private JPanel editorPanel;
    private JPanel panel;
}
    

