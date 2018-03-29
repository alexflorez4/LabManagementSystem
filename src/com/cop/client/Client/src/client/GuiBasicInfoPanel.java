/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Carlos Guisao
 */
public class GuiBasicInfoPanel {
    
    public JComponent createUserInfoPanel(int x, int y){
        
        if (panel == null) {
            panel = new JPanel();
            // 650, 90
            panel.setPreferredSize(new Dimension(x, y));
            panel.setLayout(new GridLayout(0,4));
            panel.setBackground(Color.WHITE);
            
            
            userLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
            userLabel.setPreferredSize( new Dimension(20, 24));
            
            user.setFont(new Font("SansSerif", Font.PLAIN, 15));
            user.setPreferredSize( new Dimension(20, 24));
            
            userTypeLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
            userTypeLabel.setPreferredSize( new Dimension( 20, 24 ));
            
            userType.setFont(new Font("SansSerif", Font.PLAIN, 15));
            userType.setPreferredSize( new Dimension( 20, 24 ));
            
            panel.add(userLabel);
            panel.add(user);
            panel.add(userTypeLabel);
            panel.add(userType);
            
        } else {
            
        }
        return panel;
    }
    
    private transient JPanel panel;
    private final transient JLabel userLabel = new JLabel("User: ", SwingConstants.CENTER);
    private final transient JLabel user = new JLabel("Place holder ", SwingConstants.CENTER);
    private final transient JLabel userTypeLabel = new JLabel("Type: ", SwingConstants.CENTER);
    private final transient JLabel userType = new JLabel("Place Holder ", SwingConstants.CENTER);
    
}
