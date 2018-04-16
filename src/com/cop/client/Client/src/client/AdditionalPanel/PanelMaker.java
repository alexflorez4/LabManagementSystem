/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdditionalPanel;

import client.model.User;

/**
 *
 * @author Carlos Guisao
 */
public class PanelMaker {
    
    public PanelMaker(User user){
        viewMyReservation = new ViewMyReservation();
        makeReservation =  new MakeReservation();
        cancelReservation = new CancelReservation();
        viewLabSchedule = new ViewLabSchedule();
        viewLabAccomodation = new ViewLabAccomodation();
        addLab = new AddLab();
        cancelLab = new CancelLab();
        DeleteLab = new DeleteLab();
        this.user = user;
    }
    
    public void drawViewRservation(){
        viewMyReservation.draw(user);
    }
    
    public void drawMakeReservation(){
        makeReservation.draw(user);
    }
    
    public void drawCancelRervation(){
        cancelReservation.draw(user);
    }
    
    public void drawViewLabSch(){
        viewLabSchedule.draw(user);
    }
    
    public void drawViewLabAcc(){
        viewLabAccomodation.draw(user);
    }
    
    public void drawAddLab(){
        addLab.draw(user);
    }
    
    public void drawCancelLab(){
        cancelLab.draw(user);
    }
    
    public void drawDeleteLab(){
        DeleteLab.draw(user);
    }
    
    private final Panel viewMyReservation;
    private final Panel makeReservation;
    private final Panel cancelReservation;
    private final Panel viewLabSchedule;
    private final Panel viewLabAccomodation;
    private final Panel addLab;
    private final Panel cancelLab;
    private final Panel DeleteLab;
    private final User user;
}
