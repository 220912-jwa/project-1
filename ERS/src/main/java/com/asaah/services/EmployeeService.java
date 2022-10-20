package com.asaah.services;

import com.asaah.daos.EmployeeDAO;
import com.asaah.daos.ReimRequestDAO;
import com.asaah.entities.Employee;
import com.asaah.entities.ReimRequest;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO employeeDAO;
    private ReimRequestDAO reimRequestDAO;

    public EmployeeService(EmployeeDAO employeeDAO, ReimRequestDAO reimRequestDAO) {
        this.employeeDAO = employeeDAO;
        this.reimRequestDAO = reimRequestDAO;
    }


    public ReimRequest getReimRequestById(int id) {
        return reimRequestDAO.getById(id);
    }



    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeDAO.getById(employeeId);
    }

    public void updateEmployee(Employee toBeUpdated) {
        employeeDAO.update(toBeUpdated);
    }

    public void deleteEmployee(int employeeId) {
        employeeDAO.delete(employeeId);
    }

    public Employee login(String username, String password) {
        return null;
    }
}
