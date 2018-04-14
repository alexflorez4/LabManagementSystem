package com.cop.client;

import com.cop.dao.SystemCheckedException;
import com.cop.model.LabDetailsModel;
import com.cop.model.LabSchedule;
import com.cop.model.UserModel;
import com.cop.service.LabService;
import com.cop.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {

    public static void main(String[] args) throws SystemCheckedException {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");

        try {

            //USER
            UserService userService = (UserService) container.getBean(UserService.class);
            //userService.createUser(new UserModel("Peter", "pet", "student", "1"));
            //userService.createUser(new UserModel("User4", "admin", "1"));

            /*System.out.println("USers: ");
            List<UserModel> users = userService.getAllUsers();
            for(UserModel um : users){
                System.out.println(um.toString());
            }
            System.out.println("End of Users **");*/

            // LAB
            LabService labService = (LabService)container.getBean(LabService.class);

            List<String> items = new ArrayList<>();
            items.add("tv");
            items.add("projector");
            items.add("pcs");
            //labService.addLabService("admin", new LabDetailsModel(0, "lab3","ee101", items));


            //labService.addLabService("admin", new LabDetailsModel(0, "lab4","ee101", items));

            /*List<LabDetailsModel> labs = labService.getAllLabs();
            for(LabDetailsModel ld : labs){
                System.out.println(ld.toString());
            }*/

            //LabDetailsModel lab = labService.viewLabAccService(30);
            //System.out.println(lab.toString());

            //labService.makeReservationService("")

            //labService.deleteLabService("admin", 50);

           /* List<LabDetailsModel> labss = labService.getAllLabs();
            for(LabDetailsModel ld : labss){
                System.out.println(ld.toString());
            }*/

            String myFirstReservation = labService.makeReservationService("pet", 11, "2018-4-18 9:00", "2018-4-18 10:00");
            System.out.println("New Reservation: " + myFirstReservation);

            List<LabSchedule> labSchedule = labService.viewLabSchedService(11);

            for(LabSchedule ls : labSchedule){
                System.out.println(ls.toString());
            }

        } finally {
            container.close();
        }
    }
}
