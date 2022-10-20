package com.asaah.daos;

import com.asaah.entities.Employee;
import com.asaah.entities.User;
import com.asaah.utils.ConnectionUtil;

import javax.management.relation.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements GenericDAO<User> {
    private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public User getUserByUsername(String username) {

        String sql = "select * from " +
                "(select id, username, pass, first_name, last_name, null as available_reimbursement, " +
                "union " +
                "select id, username, pass, first_name, last_name, available_reimbursement, " +
                "null as col6 from employees em) " +
                "as u " +
                "where username = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {

                if ((rs.getString("is_manager"))==null) {
                    System.out.println("returning employee");
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("pass"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("is_manager"),
                            rs.getInt("available_reimbursement"));

                }
                else {
                    System.out.println("returning manager");
                    Employee em = new Employee(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("pass"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("is_manager")
                    );
                    return em;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void update(User tUpdated) {

    }

    @Override
    public void delete(int id) {

    }





}
