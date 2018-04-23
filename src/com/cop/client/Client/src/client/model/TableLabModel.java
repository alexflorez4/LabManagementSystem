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
public class TableLabModel extends AbstractTableModel{
    
    List wordsList;
    String[] headerList = 
            new String[] {"ID", "Name", "Location", "Accomodations"};
    
    public TableLabModel(List list) {
        wordsList = list;
    }
    
    @Override
    public int getRowCount() {
        return wordsList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        LabDetails lab = new LabDetails();
        lab = (LabDetails) wordsList.get(row);
        
        switch(column){
            case 0:
                return lab.getId();
            case 1:
                return lab.getName();
            case 2:     
                return lab.getLocation();
            case 3:
                return lab.getAccommodations();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int col) {
        return headerList[col];
    }
}
