package controllers;

import entities.User;
import services.AuthenticationService;
import io.javalin.http.Handler;

public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Handler login = ctx -> {
        // Author a =  ctx.bodyAsClass(Author.class);
        User u = ctx.bodyAsClass(User.class); // Jackson Library is mapping all fields from the JSON to our Author Class

        User authenticatedUser = authenticationService.login(u.getUsername(), u.getPassword());
        // Session Management
        ctx.sessionAttribute("loggedInUser", authenticatedUser);

       // for controlling what resources to provide access to we can use the session storage
        // to refer to the currently logged in user and check they're role
        // if they're allowed let them do it
        // otherwise -> 403 or some status or some error page.
        // and then when they logout -> we invalidate their session so there is no logged in user.

        if (authenticatedUser != null) {
            ctx.status(200);
            ctx.json(authenticatedUser);

        }
    };


}
