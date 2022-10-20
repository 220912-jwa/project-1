package com.asaah.entities;

import java.sql.Date;

public class ReimRequest {
    private int id;
    private int empId;
    private int eventTypeId;
    private Date eventDate;
    private Date submittedOn;
    private String location;
    private int cost;
    private String status;


    public ReimRequest() {
    }
    public ReimRequest(int requestId, int empId, int eventTypeId, Date eventDate, Date submittedOn, String location,
                       int cost, String status) {

        this.eventDate = eventDate;
        this.submittedOn = submittedOn;
        this.location= location;
        this.cost = cost;
        this.status = status;

    }

    public ReimRequest(int id, int empId, int eventTypeId, Date eventDate, Date submittedOn, String location,
                       String status) {
        this.id = id;
        this.id = empId;
        this.id = eventTypeId;
        this.eventDate = eventDate;
        this.submittedOn = submittedOn;
        this.location= location;
        this.cost = cost;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }


    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }


    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "id=" + id +
                "empId=" + id +
                "eventTypeId=" + id +
                ", eventDate='" + eventDate +
                ", submittedOn='" + submittedOn +
                ", location='" + location + '\'' +
                ", status=" + status + '\'' +
                ", cost=" + cost +
                '}';
    }


    public EventType getEventType() {
        return null;
    }

    public Employee getEmployee() {
        return null;
    }
}
