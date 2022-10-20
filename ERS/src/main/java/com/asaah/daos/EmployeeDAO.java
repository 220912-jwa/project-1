package com.asaah.daos;

import com.asaah.entities.Employee;
import com.asaah.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements GenericDAO<Employee>{
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Employee getById(int id) {
        String sql = "select * from employee where id = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id); // our statement is now 'select * from employees where id = 1
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("is_manager"),
                        rs.getInt("available_reimbursement"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Employee getEmployeesByUsername(String username) {

        String sql = "select * from employees where username = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employee(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("is_manager"),
                        rs.getInt("available_reimbursement"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        String sql = "select * from employees";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("is_manager"),
                        rs.getInt("available_reimbursement")));
            }
            return employees;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee create(Employee e) {
        String sql = "insert into employees values (default, ?, ?, ?, ?, ?) returning *";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getFirstName());
            ps.setString(4, e.getLastName());
            ps.setInt(5, 400);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("is_manager"),
                        rs.getInt("available_reimbursement"));
            }
        } catch (SQLException ex) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Employee eUpdated) {
        String sql = "update employees set username = ?, pass = ?, first_name = ?, last_name = ?, " +
                "available_reimbursement = ? "
                + "where id = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, eUpdated.getUsername());
            ps.setString(2, eUpdated.getPassword());
            ps.setString(3, eUpdated.getFirstName());
            ps.setString(4, eUpdated.getLastName());
            ps.setInt(5, eUpdated.getAvailableReimbursement());
            ps.setInt(6, eUpdated.getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from employees where id = ?";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }






}
