/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.MainPanel;

import client.model.User;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Guisao
 */
public class GuiAppMainPanel {

    public GuiAppMainPanel() {
        this.mainFrame = new JFrame("FAU LMS Dashboard");
    }
    
    public void CreateMainPanel(User user){
        
        mainFrame.setPreferredSize(new Dimension(700, 850));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        PanelFactory panelFactory = new PanelFactory();
        
        Panel info = panelFactory.GetPanel("Info", user);
        infoPanel.add(info.GetPanel(650, 90));
        mainFrame.add(infoPanel);
        
        Panel action = panelFactory.GetPanel("Action", user);
        actionPanel.add(action.GetPanel(650, 300));
        mainFrame.add(actionPanel);
        
        Panel reserve = panelFactory.GetPanel("Reserve", user);
        displayPanel.add(reserve.GetPanel(650, 300));
        mainFrame.add(displayPanel);
        
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    private class WindowCloseManager extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent evt){
            exitApplication();
        }
    }
    
    private void exitApplication(){
        System.exit(0);
    }
    
    private final JFrame mainFrame;
    private final JPanel infoPanel = new JPanel();;
    private final JPanel actionPanel = new JPanel();
    private final JPanel displayPanel = new JPanel();
}
