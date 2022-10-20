package com.asaah;


import com.asaah.controllers.AuthenticationController;
import com.asaah.controllers.EmployeeController;
import com.asaah.controllers.ReimRequestController;
import com.asaah.daos.EmployeeDAO;
import com.asaah.daos.ReimRequestDAO;
import com.asaah.daos.UserDAO;
import com.asaah.services.AuthenticationService;
import com.asaah.services.EmployeeService;
import com.asaah.services.ReimRequestService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;

public class AppDriver {

    public static void main(String[] args) {
        // Controller for authentication
        AuthenticationController ac = new AuthenticationController(new AuthenticationService(new UserDAO()));

        // DAOS
        EmployeeDAO employeeDAO = new EmployeeDAO();

        ReimRequestDAO reimRequestDAO = new ReimRequestDAO();

        // SERVICES
        EmployeeService employeeService = new EmployeeService(employeeDAO, reimRequestDAO);
        ReimRequestService reimRequestService = new ReimRequestService(reimRequestDAO);



        // CONTROLLERS
        EmployeeController employeeController = new EmployeeController(employeeService);
        ReimRequestController reimRequestController = new ReimRequestController(reimRequestService);


        Javalin app = Javalin.create(config -> {
                    config.enableCorsForAllOrigins();
                    config.addStaticFiles("/public", Location.CLASSPATH);
                }
        ).start(8080);



        app.routes(() -> {
            path("/authenticate", () -> {
                post(ac.login);
            });

//            path("/logout", () -> {
//                delete(ctx -> {
//                    ctx.json("getSession").req().logout();
//                });
//            });


            path("/employees", () -> { // http://localhost:8080/employees
                get(employeeController::getAllEmployees);

                path("/{id}", () -> { // http://localhost:8080/employees/2
                    get(employeeController::getEmployeeById);
                    put(employeeController::updateEmployee);

                });
            });

            path("/requests", () -> {
                get(reimRequestController::getAllRequests);
                post(reimRequestController::createRequest);
                path("/{id}", () -> {
                    get(reimRequestController::getRequestById);
                    put(reimRequestController::updateRequest);


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

    }

}