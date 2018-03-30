/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.Login;

/**
 *
 * @author Carlos Guisao
 */
public class UserView {
    
    public void printUsersDetails(int id, String name, String type){
        System.out.println("User: ");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
    }
}
