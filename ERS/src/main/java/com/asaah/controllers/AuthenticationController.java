package com.asaah.controllers;

import com.asaah.entities.Employee;
import com.asaah.entities.User;
import com.asaah.services.AuthenticationService;
import io.javalin.http.Handler;

public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Handler login = ctx -> {

        User u = ctx.bodyAsClass(Employee.class);

        User authenticatedUser = authenticationService.login(u.getUsername(), u.getPassword());

        ctx.sessionAttribute("loggedInUser", authenticatedUser);


        if (authenticatedUser != null) {
            ctx.status(200);
            ctx.json(authenticatedUser);

        }
    };


    public Employee login(String username, String password) {
        return null;
    }
}
