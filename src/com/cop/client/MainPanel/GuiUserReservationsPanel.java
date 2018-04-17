/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.client.MainPanel;


import com.cop.client.model.LabDetails;
import com.cop.client.model.TableModel;
import javax.swing.JScrollPane;
import com.cop.client.model.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import static com.cop.client.RESTCaller.callURL;

/**
 *
 * @author Carlos Guisao
 */
public class GuiUserReservationsPanel implements Panel{

    public GuiUserReservationsPanel(User user) {
        this.panel = new JPanel();
    }
    
    @Override
    public JComponent GetPanel(int x, int y){

        panel.setPreferredSize(new Dimension(x, y));
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.WHITE);
        
        String URL = callURL("http://localhost:8080/faulms/getAllLabs/");
        System.out.println("\n============Output:============ \n" + URL);
        
        ObjectMapper objectMapper = new ObjectMapper();
    	TypeReference<List<LabDetails>> mapType = new TypeReference<List<LabDetails>>() {};
    	List<LabDetails> jsonToPersonList = null;
        try {
            jsonToPersonList = objectMapper.readValue(URL, mapType);
        } catch (IOException ex) {
            Logger.getLogger(GuiUserReservationsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        panel.setBorder (BorderFactory.createTitledBorder 
                
        (BorderFactory.createEtchedBorder (), "All Laboratories", TitledBorder.CENTER, TitledBorder.TOP, 
                new Font("times new roman",Font.BOLD,20)));

        JTable table = new JTable();
        table.setRowHeight(30);
        TableModel model = new TableModel(jsonToPersonList);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setModel(model);
        panel.add(scrollPane);

        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.WHITE);

        return panel;
    }
    
    private final JPanel panel;
}
