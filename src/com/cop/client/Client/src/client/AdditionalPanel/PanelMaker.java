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
        viewAllUsers = new ViewAllUsers();
        createNewUser = new CreateNewUser();
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
    
    public void drawViewAllUsers(){
        viewAllUsers.draw(user);
    }
    
    public void drawCreateNewUser(){
        createNewUser.draw(user);
    }
    
    private final FacadePanel viewMyReservation;
    private final FacadePanel makeReservation;
    private final FacadePanel cancelReservation;
    private final FacadePanel viewLabSchedule;
    private final FacadePanel viewLabAccomodation;
    private final FacadePanel addLab;
    private final FacadePanel cancelLab;
    private final FacadePanel DeleteLab;
    private final FacadePanel viewAllUsers;
    private final FacadePanel createNewUser;
    private final User user;
}
