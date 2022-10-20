package controllers;

import daos.EventDAO;
import entities.User;
import entities.Event;
import services.EventService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import services.UserService;

import java.io.IOException;
import java.util.List;

public class EventController {
    private EventService eventService;
    private UserService userService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // GET http://lovalhost:8080/pitches/1
    public void getAllEvents(Context ctx) {
        List<Event> events = eventService.getAllEvents();
        ctx.status(200);
        ctx.json(events);
    }

    public void getEventById(Context ctx) {
        // check to make sure the user is logged in to the current session - to do later
        int id = Integer.parseInt(ctx.pathParam("id"));
        Event e = eventService.getEventById(id);

        if (e != null) {
            //what?
            ctx.status(200);
            ctx.json(e);
        }
    }

    public void getAllEventsByUserId(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));

        User a = userService.getUserById(userId);
        System.out.println(a);
        ctx.status(200);
        ctx.json(eventService.getAllEventsofRequester(userId));
    }

    public void getAllEventsManager(Context ctx) {
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

    public void createEvent(Context ctx) throws IOException {
        // read the body of the request
        Event e = ctx.bodyAsClass(Event.class); // unmarshalling json string from front end into a Java Object

        // use service and by extension Dao to create that new pitch
        Event newEvent = eventService.createEvent(e);

        if (newEvent != null) {
            // set a status for the response
            ctx.status(HttpCode.CREATED); // I prefer this over status(201);

            // write new story pitch to body of response (mostly so that we can have access to it's id on the front end)
            ctx.json(newEvent);
        } else {
            ctx.res.sendError(400);
        }


    }

    public void updateEvent(Context ctx) {
        Event toBeUpdated = ctx.bodyAsClass(Event.class);
        eventService.updateEvent(toBeUpdated);
        ctx.status(HttpCode.NO_CONTENT);
    }

    public void deleteEvent(Context ctx) {
        int eventId = Integer.parseInt(ctx.pathParam("id"));
        eventService.deleteEvent(eventId);
        ctx.status(HttpCode.NO_CONTENT);
    }
}
