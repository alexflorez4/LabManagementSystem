package com.cop.client;

import com.cop.dao.SystemCheckedException;
import com.cop.model.UserModel;
import com.cop.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {

    public static void main(String[] args) throws SystemCheckedException {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");

        try {
            UserService userService = (UserService) container.getBean(UserService.class);
            userService.createUser(new UserModel("User1", "abc", "admin"));
        } finally {
            container.close();
        }
    }
}
