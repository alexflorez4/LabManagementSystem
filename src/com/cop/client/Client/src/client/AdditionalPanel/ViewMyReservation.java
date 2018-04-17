/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import client.model.User;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 *
 * @author Carlos Guisao
 */
public class ViewMyReservation implements FacadePanel{
    
    @Override
    public void draw(User user){
        mainFrame = new JFrame("View Lab Schedule");
        mainFrame.setPreferredSize(new Dimension(400, 300));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    private JFrame mainFrame;
}
