/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Guisao
 */
public class GuiActionsPanel {
    
    public JComponent GuiActionsPanel(int x, int y){
        
        if (panel == null) {
            panel = new JPanel();
            panel.setPreferredSize(new Dimension(x, y));
            panel.setLayout(new GridLayout(0,2));
            panel.setBackground(Color.WHITE);
            BorderLayout layout = new BorderLayout();
            layout.setHgap(5);
            layout.setVgap(5);
            panel.setLayout(layout);
            
        } else {
            
        }
        return panel;
    }
    
    private transient JPanel panel;
}
