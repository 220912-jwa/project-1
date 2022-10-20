package com.asaah.daos;

import com.asaah.entities.Employee;
import com.asaah.entities.EventType;
import com.asaah.entities.ReimRequest;
import com.asaah.utils.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimRequestDAO implements GenericDAO<ReimRequest> {

    private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public ReimRequest getById(int id) {

        // we write our query
        String sql = "select rr.id as request_id, event_date, rr.submitted_on, rr.location, rr.cost, rr.emp_id," +
                "rr.status,\n" +
                "et.event_type, em.id as emp_id, e.username, e.pass, e.first_name, e.last_name, is_manager, " +
                "e.available_reimbursement\n" +
                "from reim_request rr\n" +
                "left join event_type et on (rr.event_type_id = et.id)\n" +
                "left join employees em on (rr.emp_id = em.id)\n" +
                "where rr.id = ?";

        // we prepare our statement
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {// from ResultSet we will need to
                // create an employee object
                Employee em = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("is_manager"),
                        rs.getInt("available_reimbursement"));


                ReimRequest rr = new ReimRequest(
                        rs.getInt("request_id"),
                        rs.getInt("emp_id"),
                        rs.getInt("event_type_id"),
                        rs.getDate("event_date"),
                        rs.getDate("submitted_on"),
                        rs.getString("location"),
                        rs.getInt("cost"),
                        rs.getString("status"));


                return rr;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ReimRequest> getAll() {
        List<ReimRequest> requests = new ArrayList<>();

        String sql = "select rr.id as request_id, rr.event_date, rr.description, rr.submitted_on, " +
                "ev.event, em.id as emp_id, e.username, e.pass, e.first_name, e.last_name, is_manager," +
                "e.available_reimbursement " +
                "from reim_request rr " +
                "left join event_type et on (rr.event_type = et.id) " +
                "left join employees em on (rr.emp_id = em.id)";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee em = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("is_manager"),
                        rs.getInt("available_reimbursement")
                );

                ReimRequest newReimRequest = new ReimRequest(

                        rs.getInt("request_id"),
                        rs.getInt("emp_id"),
                        rs.getInt("event_type_id"),
                        rs.getDate("event_date"),
                        rs.getDate("submitted_on"),
                        rs.getString("location"),
                        rs.getInt("cost"),
                        rs.getString("status"));



                requests.add(newReimRequest);
            }
            return requests;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public ReimRequest create(ReimRequest reimRequest) {

        String sql = "with new_request as (insert into reim_request values " +
                "(default, ?, to_date(?, 'YYYY-MM-DD'), ?, to_date(?, 'YYYY-MM-DD'), ?, ?, ?, ?) returning *) " +
                "select nr.id as request_id, nr.event_date, nr.description," +
                " nr.submitted_on,  " +
                "et.event_type, em.id as employee_id, e.username, e.pass, e.first_name, e.last_name, " +
                "e.available_reimbursement " +
                "left join event_type ev on (nr.event_type = et.id) " +
                "left join employees em on (nr.employee_id = em.id)";


        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(2, reimRequest.getEventDate());
            ps.setString(4, reimRequest.getSubmittedOn().toString());
            ps.setString(5, reimRequest.getLocation());
            ps.setString(6, reimRequest.getStatus());
            ps.setInt(7, reimRequest.getCost());
            ps.setInt(8, reimRequest.getEmpId());
            ps.setInt(9, reimRequest.getEventTypeId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                reimRequest.setId(rs.getInt("request_id"));
                return reimRequest;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(ReimRequest tUpdated) {
        String sql = "update reim_request event_date = ?, description = ?, " +
                "submitted_on = ?, location = ?, status = ?, cost = ?, employee_id = ? " +
                "where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(2, tUpdated.getEventDate());
            ps.setString(4, tUpdated.getSubmittedOn().toString());
            ps.setString(5, tUpdated.getLocation());
            ps.setString(6,tUpdated.getStatus());
            ps.setInt(7, tUpdated.getCost());
            ps.setInt(8, tUpdated.getEmpId());
            ps.setInt(9, tUpdated.getEventTypeId());
            ps.setInt(10, tUpdated.getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from reim_request where id = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ReimRequest> getAllRequestsByEmployeeId(int employeeId) {

        List<ReimRequest> requests = new ArrayList<>();

        String sql = "select rr.id as request_id, rr.event_date, " +
                "ev.event, em.id as employee_id, e.username, e.pass, e.first_name, e.last_name, " +
                "e.available_reimbursement " +
                "from reimbursement_request rr " +
                "left join event ev on (ev.event = ev.id) " +
                "left join employees em on (rr.employee_id = em.id) " +
                "where rr.id = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee em = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("is_manager"),
                        rs.getInt("available_reimbursement")
                );

                ReimRequest newReimRequest = new ReimRequest(

                        rs.getInt("request_id"),
                        rs.getInt("emp_id"),
                        rs.getInt("event_type_id"),
                        rs.getDate("event_date"),
                        rs.getDate("submitted_on"),
                        rs.getString("location"),
                        rs.getInt("cost"),
                        rs.getString("status"));





                requests.add(newReimRequest);
            }
            return requests;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }








}
