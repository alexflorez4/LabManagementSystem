/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.MainPanel;

import client.MainPanel.Panel;
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
public class GuiBasicInfoPanel implements Panel{

    public GuiBasicInfoPanel() {
        
        this.panel = new JPanel();
        this.userType = new JLabel("Place Holder ", SwingConstants.CENTER);
        this.userTypeLabel = new JLabel("Type: ", SwingConstants.CENTER);
        this.user = new JLabel("Place holder ", SwingConstants.CENTER);
        this.userLabel = new JLabel("User: ", SwingConstants.CENTER);
    }
    
    @Override
    public JComponent GetPanel(int x, int y){

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

        return panel;
    }
    
    private final JPanel panel;
    private final JLabel userLabel;
    private final JLabel user;
    private final JLabel userTypeLabel;
    private final JLabel userType;   
}
