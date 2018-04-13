/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import client.Login.loginPanel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 *
 * @author Carlos Guisao
 */
public class AddLab implements Panel{
    
    @Override
    public void draw(){
        mainFrame = new JFrame("Add Lab");
        mainFrame.setPreferredSize(new Dimension(400, 300));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    private JFrame mainFrame;
    
}
