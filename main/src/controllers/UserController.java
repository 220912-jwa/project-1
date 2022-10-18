package controllers;

import daos.UserDAO;
import entities.User;
import entities.Event;
import services.EventService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import services.UserService;

import java.util.List;

public class UserController {

    private EventService eventService;
    private UserService userService;

    public UserController(UserService eventService) {
        this.userService = userService;
    }

    // GET http://lovalhost:8080/pitches/1
    public void getUserById(Context ctx) {
        // check to make sure the user is logged in to the current session - to do later
        int id = Integer.parseInt(ctx.pathParam("id"));
        User e = userService.getUserById(id);

        if (e != null) {
            //what?
            ctx.status(200);
            ctx.json(e);
        }
    }

    public void getAllUsers(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));

        User a = userService.getUserById(userId);
        System.out.println(a);
        ctx.status(200);
        ctx.json(eventService.getAllEventsofRequester(userId));
    }

    public void getAllEmployeesOfManager(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));

        User a = userService.getUserById(userId);
        System.out.println(a);
        ctx.status(200);
        ctx.json(userService.getAllEmployeesOfManager(userId));
    }

    public void getAllEventsOfManager(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));

        User a = userService.getUserById(userId);
        System.out.println(a);
        ctx.status(200);
        ctx.json(eventService.getAllEventsofManager(userId));
    }

    public void getManager(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));

        User a = userService.getUserById(userId);

        if (a != null) {
            ctx.status(HttpCode.OK);
            ctx.json(a);
        }
    }

    public void updateUser(Context ctx) {
        User toBeUpdated = ctx.bodyAsClass(User.class);
        userService.updateUser(toBeUpdated);
        ctx.status(HttpCode.NO_CONTENT);
    }

    public void deleteUser(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));
        userService.deleteUser(userId);
    }
}
