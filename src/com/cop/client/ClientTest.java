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
            //UserService userService = (UserService) container.getBean(UserService.class);
            //userService.createUser(new UserModel("User1", "abc", "admin"));

            LabService labService = (LabService)container.getBean(LabService.class);
            List<String> items = new ArrayList<>();
            items.add("tv");
            items.add("projector");

            //labService.addLabService("admin", new LabDetailsModel(0, "lab1","ee101", items));
            labService.deleteLabService("admin", 10);
        } finally {
            container.close();
        }
    }
}
