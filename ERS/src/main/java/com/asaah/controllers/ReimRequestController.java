package com.asaah.controllers;

import com.asaah.entities.ReimRequest;
import com.asaah.services.ReimRequestService;
import io.javalin.http.Context;

import java.io.IOException;
import java.util.List;

public class ReimRequestController {
    private ReimRequestService requestService;

    public ReimRequestController(ReimRequestService requestService) {
        this.requestService = requestService;
    }


    public void createRequest(Context ctx) throws IOException {
        // read the body of the request
        ReimRequest rr = ctx.bodyAsClass(ReimRequest.class); // unmarshalling json string from front end into a
        // Java Object

        // use service and by extension Dao to create that new pitch
        ReimRequest newReimRequest = requestService.createNewRequest(rr);

        if (newReimRequest != null) {
            // set a status for the response
            ctx.status(201); // I prefer this over status(201);

            // write new story pitch to body of response (mostly so that we can have access to it's id on the front end)
            ctx.json(newReimRequest);
        }
        else {
            ctx.status(201);
        }


    }

    public void getAllRequestsByEmployeeId(Context ctx) {
        int employeeId = Integer.parseInt(ctx.pathParam("id"));
        List<ReimRequest> requests = requestService.getAllRequestsByEmployeeId(employeeId);
        ctx.status(200);
        ctx.json(requests);
    }

    public void getAllRequests(Context ctx) {
        List<ReimRequest> requests = requestService.getAllRequests();
        ctx.status(200);
        ctx.json(requests);
    }

    public void getRequestById(Context ctx) {
        int requestId = Integer.parseInt(ctx.pathParam("id"));

        ReimRequest rr = requestService.getRequestById(requestId);
        if (rr!=null) {
            ctx.status(200);
            ctx.json(rr);
        }
    }

    public void updateRequest(Context ctx) {
        ReimRequest toBeUpdated = ctx.bodyAsClass(ReimRequest.class);
        requestService.updateRequest(toBeUpdated);
        ctx.status(204);
    }

    public void deleteRequest(Context ctx) {
        int requestId = Integer.parseInt(ctx.pathParam("id"));
        requestService.deleteRequest(requestId);
        ctx.status(204);
    }





}
