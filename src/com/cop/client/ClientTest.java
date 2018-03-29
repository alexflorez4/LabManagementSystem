package com.cop.client;

import com.cop.dao.SystemCheckedException;
import com.cop.model.LabDetailsModel;
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
            //userService.createUser(new UserModel("User3", "admin", "1"));
            //userService.createUser(new UserModel("User4", "admin", "1"));

            /*List<UserModel> users = userService.getAllUsers();
            for(UserModel um : users){
                System.out.println(um.toString());
            }*/


            // LAB
            LabService labService = (LabService)container.getBean(LabService.class);

            List<String> items = new ArrayList<>();
            items.add("tv");
            items.add("projector");

            //labService.addLabService("admin", new LabDetailsModel(0, "lab3","ee101", items));

            items.add("pcs");
            //labService.addLabService("admin", new LabDetailsModel(0, "lab4","ee101", items));

            List<LabDetailsModel> labs = labService.getAllLabs();
            for(LabDetailsModel ld : labs){
                System.out.println(ld.toString());
            }

            labService.deleteLabService("admin", 50);

            List<LabDetailsModel> labss = labService.getAllLabs();
            for(LabDetailsModel ld : labss){
                System.out.println(ld.toString());
            }


        } finally {
            container.close();
        }
    }
}
