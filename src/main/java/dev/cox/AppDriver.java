package dev.cox;

import dev.cox.controllers.AuthenticationController;
import dev.cox.controllers.UserController;
import dev.cox.controllers.EventController;

import dev.cox.daos.UserDAO;
import dev.cox.daos.EventDAO;
import dev.cox.services.AuthenticationService;
import dev.cox.services.UserService;
import dev.cox.services.EventService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;


public class AppDriver {

    public static void main(String[] args) {
        // Controller for authentication
        AuthenticationController ac = new AuthenticationController(new AuthenticationService(new UserDAO()));

        // DAOS
        UserDAO userDAO = new UserDAO();
        EventDAO eventDAO = new EventDAO();

        // SERVICES
        UserService userService = new UserService(userDAO, eventDAO);
        EventService eventService = new EventService(eventDAO);

        // CONTROLLERS
        UserController userController = new UserController(userService);
        EventController eventController = new EventController(eventService);


        Javalin app = Javalin.create(config -> {

                config.enableCorsForAllOrigins(); // enable cors for all origins -> adding a Header like this: "Access-Control-Allow-Origins: *"

                config.addStaticFiles("/public", Location.CLASSPATH); // let Javalin know that you're using static files and where they're located (because they're in our src/main/resources folder - they will be on the classpath when the program compiles
            }
        ).start(8080); // this is the default port number - you could make it anything (or almost anything) you'd like.


        // having lots of different app.httpMethod(path, handler) can get a little messy and hard to organize.
        // instead we can use the .routes() method - it takes an EndpointGroup that we can use lambda expressions for

        // ENDPOINTS
        app.routes(() -> {
            // Login - this is the same as we had before app.post("/authenticate", ac.login);  // we send a post request for login - so that sensitive information isn't displayed in the url
            path("/authenticate", () -> {
                post(ac.login);
            });
            // Logout -> really only to invalidate the session
            path("/logout", () -> {
                delete(ctx -> {
                    ctx.req.getSession().invalidate();
                });
            });

            path("/users", () -> { // http://localhost:8080/users
                get(userController::getAllUsers);

                path("/{id}", () -> { // http://localhost:8080/users/2
                    get(userController::getUserById);
                    put(userController::updateUser);
                    delete(userController::deleteUser);

                    path("/events", () -> { // http://localhost:8080/users/2/events
                        post(eventController::createEvent);
                        get(eventController::getAllEventsByUserId);
                    });
                });
            });

            path("/events", () -> {
                get(eventController::getAllEvents);
                post(eventController::createEvent);
                path("/{id}", () -> {
                    get(eventController::getEventById);
                    post(eventController::approve);
                    put(eventController::deny);
//                    patch(userController::approveEvent);
                    delete(eventController::deleteEvent);
                });
            });
        });


        app.get("/getSession", ctx -> {
            if (ctx.sessionAttribute("loggedInUser") != null) {
                ctx.json(ctx.sessionAttribute("loggedInUser"));
            } else {
                ctx.json("No user is logged in atm");
            }

        });
            /*
                    // RESTful Naming Conventions
                            // we build our endpoints according to a Rest Standard
                            // we use the class name as the 'collection'
                            // we can add on a parameter (like an id) to reference a specific resource in a collection.


                    // CRUD methods? -> Create, Read, Update, Delete
                    // POST = Create a resource
                    // GET = Read a resource
                    // PUT = Update a resource (will replace the entire representation of the resource on the server)
                        // PATCH = Updates only part of the resource without replace all of it.
                    // DELETE = Delete a resource


             *     GET /authors -> this should return all authors (all resources in the authors collection)
             *     POST /authors -> this should create a new author resource
             *
             *     GET /authors/1 -> this should return the author resource that has an id of 1
             *     PUT /authors/1 -> this will update the author resource that has an id of 1
             *     DELETE /authors/1 -> this will delte the author resource that has an id of 1
             *
             *     GET /authors/1/pitches -> this should return all StoryPitch resources for the author resource with an id of 1
             *     POST /authors/1/pitches -> this would create a story pitch resource on the author resource that has an id of 1
             *
             *     GET /authors/1/pitches/1 -> this should return the StoryPitch resource with an id of 1 from the author resource
             *
             *     GET /pitches
             *     GET /pitches/1
             *     POST /pitches
             *     PUT /pitches/1
             *
             *
             */

    }

}
