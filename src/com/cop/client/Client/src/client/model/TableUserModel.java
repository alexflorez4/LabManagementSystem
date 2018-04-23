/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos Guisao
 */
public class TableUserModel extends AbstractTableModel{

     List wordsList;
    String[] headerList = 
            new String[] {"ID", "Name", "userID"};
    
    public TableUserModel(List list) {
        wordsList = list;
    }
    
    @Override
    public int getRowCount() {
        return wordsList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        User user = new User();
        user = (User) wordsList.get(row);
        
        switch(column){
            case 0:
                return user.getId();
            case 1:
                return user.getName();
            case 2:     
                return user.getUserId();
            //case 3:
                //return user.getPassword();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int col) {
        return headerList[col];
    }
}
