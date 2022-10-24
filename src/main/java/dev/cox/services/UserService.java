package dev.cox.services;

import dev.cox.daos.UserDAO;
import dev.cox.daos.EventDAO;
import dev.cox.entities.User;
import dev.cox.entities.Event;

import java.util.List;

public class UserService {

    private UserDAO userDAO;
    private EventDAO eventDAO;

    public UserService(UserDAO userDAO, EventDAO eventDAO) {
        this.userDAO = userDAO;
        this.eventDAO = eventDAO;
    }

    public User getManagerByEmployeeId(int id) {
        return userDAO.getById(userDAO.getById(id).getManager());
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public List<User> getAllEmployeesOfManager(int id) {
        return userDAO.getEmployeesOfManager(id);
    }

    public User getUserById(int userId) {
        return userDAO.getById(userId);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public void updateUser(User toBeUpdated) {
        userDAO.update(toBeUpdated);
    }

    public void deleteUser(int userId) {
        userDAO.delete(userId);
    }
}
