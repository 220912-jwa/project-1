package com.asaah.controllers;

import com.asaah.entities.Employee;
import com.asaah.entities.ReimRequest;
import com.asaah.services.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeeController {


    private EmployeeService authenticationController;
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService authenticationController) {

        this.authenticationController = authenticationController;
    }

    public Handler login = ctx -> {
        Employee e = ctx.bodyAsClass(Employee.class);
        Employee aue = authenticationController.login(e.getUsername(),e.getPassword());
        ctx.sessionAttribute("loggedInUser", aue);
        System.out.println(aue);
        if (aue != null) {
            ctx.status(200);
            ctx.json(aue);
        } else {
            ctx.status(400);
        }
    };



    public void getReimRequestById(Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("id"));
        ReimRequest rr = employeeService.getReimRequestById(id);

        if (rr != null) {
            ctx.status(200);
            ctx.json(rr);
        }
    }

    public void getAllEmployee(Context ctx) {
        // check first if the client that sent the request has permission to view that resource
        // we can do this using the session attribute
        if (ctx.sessionAttribute("loggedInUser") instanceof Employee) {
            Employee em = ctx.sessionAttribute("loggedInUser");
            System.out.println(em);
            ctx.status(200);
            ctx.json(employeeService.getAllEmployees());
        } else {
            System.out.println("sorry you can't do that");
            ctx.status(401);
        }
    }

    public void getEmployeeById(Context ctx) {
        int employeeId = Integer.parseInt(ctx.pathParam("id"));

        Employee em = employeeService.getEmployeeById(employeeId);

        if (em != null) {
            ctx.status(200);
            ctx.json(em);
        }
    }


    public void updateEmployee(Context ctx) {
        Employee toBeUpdated = ctx.bodyAsClass(Employee.class);
        employeeService.updateEmployee(toBeUpdated);
        ctx.status(500);
    }

    public void deleteEmployee(Context ctx) {
        int employeeId = Integer.parseInt(ctx.pathParam("id"));
       employeeService.deleteEmployee(employeeId);
    }


    public void getAllEmployees(Context context) {
    }
}
