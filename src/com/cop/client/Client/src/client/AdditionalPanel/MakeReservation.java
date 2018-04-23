/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import static client.RESTCaller.callURL;
import client.model.User;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Guisao
 */
public class MakeReservation implements FacadePanel{
    
    @Override
    public void draw(User user){
        this.user = user;
        mainFrame = new JFrame("Make Reservation");
        mainFrame.setPreferredSize(new Dimension(500, 300));
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        editorPanel = new JPanel();
        editorPanel.add(getMainPanel());
        content.add(editorPanel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public JComponent getMainPanel(){
        
        JLabel loginTitle = new JLabel("Reservation");
        JButton submit = new JButton ("Submit");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        submit.setPreferredSize(new Dimension(200, 24));

        labField = new JTextField(lab);
        startTime = new TimePicker();
        endTime = new TimePicker();
        datePicker1 = new DatePicker();
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.setLayout(new GridLayout(0,2));
        panel.add(loginTitle);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Laboratory ID:"));
        panel.add(labField);
        
        panel.add(new JLabel("Date:"));
        panel.add(datePicker1);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        panel.add(new JLabel("Start Time:"));
        panel.add(startTime);
        
        panel.add(new JLabel("End Time:"));
        panel.add(endTime);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        submit.addActionListener(new ButtonClickListener());
        submit.setActionCommand("Submit");
        panel.add(submit);
        
        return panel;
    }
    
    private class ButtonClickListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
            
            String command = e.getActionCommand();  
          try {
              if(command.equals("Submit") && addReservation()){
                  mainFrame.dispose();
              }
          } catch (ParseException ex) {
              Logger.getLogger(MakeReservation.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

        private boolean addReservation() throws ParseException {
            
            String id = labField.getText();
            String date = datePicker1.getText();
            String start = startTime.getText();
            String end = endTime.getText();
            
            start = hourFormater(start);
            end = hourFormater(end);        
            date = dateFormarter(date);

            System.out.println("http://localhost:8181/faulms/newreserv/" + user.getName() + "/"
                    + id + "/" + date + " " + start + "/" + date + " " + end);
            
            String URL = callURL("http://localhost:8181/faulms/newreserv/" + user.getName() + "/"
                    + id + "/" + date + "%20" + start + "/" + date + "%20" + end);
            System.out.println("\n============Output:============ \n" + URL);
            
            if(URL.equals("Success")){
                return true;
            }
            else{
                return false;
            }
        }

        private String dateFormarter(String date) {
            SimpleDateFormat dateFormater = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
            try{
                java.util.Date t=dateFormater.parse(date);
                dateFormater.applyPattern("yyyy-MM-d");
                date = dateFormater.format(t);
            } catch (ParseException ex) {
                System.out.println(ex);
            }
            return date;
        }

        private String hourFormater(String hour) {
            SimpleDateFormat Formater = new SimpleDateFormat("hh:mma");
            try{
                java.util.Date t = Formater.parse(hour);
                Formater.applyPattern("HH:mm");
                hour = Formater.format(t);
            } catch (ParseException ex) {
                System.out.println(ex);
            }
            return hour;
        }
    }
    
    private JFrame mainFrame;
    private JPanel editorPanel;
    private JPanel panel;
    private JTextField labField;
    private DatePicker datePicker1;
    private TimePicker startTime;
    private TimePicker endTime;
    private String lab;
    private User user;
}
