package dev.cox.services;

import dev.cox.daos.UserDAO;
import dev.cox.daos.EventDAO;
import dev.cox.entities.User;
import dev.cox.entities.Event;

import java.util.List;

public class EventService {

    private UserDAO userDAO;
    private EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.userDAO = userDAO;
        this.eventDAO = eventDAO;
    }

    public User getEmployeeByEventId(int id) {
        return userDAO.getById(eventDAO.getById(id).getEmployee());
    }

    public User getManagerByEventId(int id) {
        return userDAO.getById(eventDAO.getById(id).getManager());
    }

    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

    public Event createEvent(Event e) {
        return eventDAO.create(e);
    }

    public List<Event> getAllEventsofRequester(int id) {
        return eventDAO.getAllEventsOfEmployee(id);
    }

    public List<Event> getAllEventsofManager(int id) {
        return eventDAO.getAllEventsByManager(id);
    }

    public Event getEventById(int eventId) {
        return eventDAO.getById(eventId);
    }

    public void updateEvent(Event toBeUpdated) {
        eventDAO.update(toBeUpdated);
    }

    public void deleteEvent(int eventId) {
        eventDAO.delete(eventId);
    }

    public void approve(Event toBeUpdated) {
        eventDAO.approve(toBeUpdated);
    }

    public void deny(Event toBeUpdated) {
        eventDAO.deny(toBeUpdated);
    }
}
