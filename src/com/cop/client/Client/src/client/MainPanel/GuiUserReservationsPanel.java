/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.MainPanel;

<<<<<<< HEAD
import Iterator.Iterator;
import Iterator.UserRepository;
import client.Login.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
=======
import client.Login.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
>>>>>>> 2109397bd934e266bf346ae8363292234acaedaf

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
<<<<<<< HEAD
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.WHITE);
        
        listModel = new DefaultListModel();
        //listModel.addElement("Carlos");
        //listModel.addElement("Marcela");
        
        UserRepository namesRepository = new UserRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
           String name = (String)iter.next();
           listModel.addElement(name);
           System.out.println("Name : " + name);
        } 
        
        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        
        panel.add(listScrollPane);
=======
        panel.setLayout(new GridLayout(0,2));
        panel.setBackground(Color.WHITE);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        layout.setVgap(5);
        panel.setLayout(layout);
>>>>>>> 2109397bd934e266bf346ae8363292234acaedaf

        return panel;
    }
    
    private final JPanel panel;
<<<<<<< HEAD
    private DefaultListModel listModel;
    private JList list;
=======
>>>>>>> 2109397bd934e266bf346ae8363292234acaedaf
}
