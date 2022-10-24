package com.asaah.services;

import com.asaah.daos.UserDAO;
import com.asaah.entities.Employee;
import com.asaah.entities.User;

public class AuthenticationService {

    // this class will depend on the DAO layer
    private UserDAO userDAO;

    // we inject that dependency using the Constructor
    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public Employee login(String username, String password) {

        // use the input to find the record based on username
        Employee u = userDAO.getUserByUsername(username);
        System.out.println(u);

        // check that the passwords match
        if (u.getPassword().equals(password)) {
            System.out.println("Authenticated and on home page");
            return u;
        } else {
            System.out.println("Password doesn't match!!");
        }
        return null;


    }

    }
