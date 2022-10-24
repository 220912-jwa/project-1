package dev.cox.services;

import dev.cox.daos.UserDAO;
import dev.cox.entities.Event;
import dev.cox.entities.User;

public class AuthenticationService {

    // this class will depend on the DAO layer
    private UserDAO userDAO;

    // we inject that dependency using the Constructor
    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public User login(String username, String password) {

        // use the input to find the record based on username
        User u = userDAO.getUserByUsername(username);
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