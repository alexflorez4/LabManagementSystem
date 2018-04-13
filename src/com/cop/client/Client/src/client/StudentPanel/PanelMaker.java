/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.StudentPanel;

/**
 *
 * @author Carlos Guisao
 */
public class PanelMaker {
    
    public PanelMaker(){
        viewMyReservation = new ViewMyReservation();
        makeReservation =  new MakeReservation();
        cancelReservation = new CancelReservation();
        viewLabSchedule = new ViewLabSchedule();
        viewLabAccomodation = new ViewLabAccomodation();
    }
    
    public void drawViewRservation(){
        viewMyReservation.draw();
    }
    
    public void drawMakeReservation(){
        makeReservation.draw();
    }
    
    public void drawCancelRervation(){
        cancelReservation.draw();
    }
    
    public void drawViewLabSch(){
        viewLabSchedule.draw();
    }
    
    public void drawViewLabAcc(){
        viewLabAccomodation.draw();
    }
    
    private final Panel viewMyReservation;
    private final Panel makeReservation;
    private final Panel cancelReservation;
    private final Panel viewLabSchedule;
    private final Panel viewLabAccomodation;
}
