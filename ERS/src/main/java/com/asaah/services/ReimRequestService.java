package com.asaah.services;

import com.asaah.daos.ReimRequestDAO;
import com.asaah.entities.ReimRequest;

import java.util.List;

public class ReimRequestService {

    private ReimRequestDAO reimRequestDAO;

    public ReimRequestService(ReimRequestDAO reimRequestDAO) {
        this.reimRequestDAO = reimRequestDAO;
    }


    public ReimRequest createNewRequest(ReimRequest rr) {
        // any logic we need
        if (rr.getEventType().getReimbursementValue() > rr.getEmployee().getAvailableReimbursement()) {
            return null;
        }


        return reimRequestDAO.create(rr);
    }

    public List<ReimRequest> getAllRequestsByEmployeeId(int employeeId) {
        return reimRequestDAO.getAllRequestsByEmployeeId(employeeId);
    }

    public List<ReimRequest> getAllRequests() {
        return reimRequestDAO.getAll();
    }

    public ReimRequest getRequestById(int requestId) {
        return reimRequestDAO.getById(requestId);
    }

    public void updateRequest(ReimRequest toBeUpdated) {
        reimRequestDAO.update(toBeUpdated);
    }

    public void deleteRequest(int requestId) {
        reimRequestDAO.delete(requestId);
    }




}
