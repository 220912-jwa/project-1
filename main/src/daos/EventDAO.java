package daos;

import entities.Event;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO implements daos.GenericDAO<Event> {
    utils.ConnectionUtil cu = utils.ConnectionUtil.getConnectionUtil();

    @Override
    public Event getById(int id) {
        String sql = "select * from events where id = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Event(
                        rs.getInt("id"),
                        rs.getInt("typeOfClass"),
                        rs.getString("nameOfClass"),
                        rs.getInt("costOfClass"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getInt("timeOfClass"),
                        rs.getString("about"),
                        rs.getString("justification"),
                        rs.getInt("employeeID"),
                        rs.getInt("managerID"),
                        rs.getString("gradeDescription"),
                        rs.getInt("gradeingFormat"),
                        rs.getString("finalGrade"),
                        rs.getBoolean("approved"),
                        rs.getString("fullForm"),
                        rs.getString("gradeOrPresentation")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Event getEventByRequester(String username) {
        //could be useful if employees only have one request
        String sql = "select * from events where employeeID = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Event(
                        rs.getInt("id"),
                        rs.getInt("typeOfClass"),
                        rs.getString("nameOfClass"),
                        rs.getInt("costOfClass"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getInt("timeOfClass"),
                        rs.getString("about"),
                        rs.getString("justification"),
                        rs.getInt("employeeID"),
                        rs.getInt("managerID"),
                        rs.getString("gradeDescription"),
                        rs.getInt("gradeingFormat"),
                        rs.getString("finalGrade"),
                        rs.getBoolean("approved"),
                        rs.getString("fullForm"),
                        rs.getString("gradeOrPresentation")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Event getEventByManager(String username) {
        //could be useful if employees only have one request
        String sql = "select * from events where employeeID = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Event(
                        rs.getInt("id"),
                        rs.getInt("typeOfClass"),
                        rs.getString("nameOfClass"),
                        rs.getInt("costOfClass"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getInt("timeOfClass"),
                        rs.getString("about"),
                        rs.getString("justification"),
                        rs.getInt("employeeID"),
                        rs.getInt("managerID"),
                        rs.getString("gradeDescription"),
                        rs.getInt("gradeingFormat"),
                        rs.getString("finalGrade"),
                        rs.getBoolean("approved"),
                        rs.getString("fullForm"),
                        rs.getString("gradeOrPresentation")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Event> getAll() {
        List<Event> eds = new ArrayList<>();

        String sql = "select * from events";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eds.add(new Event(rs.getInt("id"),
                        rs.getInt("typeOfClass"),
                        rs.getString("nameOfClass"),
                        rs.getInt("costOfClass"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getInt("timeOfClass"),
                        rs.getString("about"),
                        rs.getString("justification"),
                        rs.getInt("employeeID"),
                        rs.getInt("managerID"),
                        rs.getString("gradeDescription"),
                        rs.getInt("gradeingFormat"),
                        rs.getString("finalGrade"),
                        rs.getBoolean("approved"),
                        rs.getString("fullForm"),
                        rs.getString("gradeOrPresentation")
                ));
            }
            return eds;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //@Override
    public List<Event> getAllEventsOfEmployee(int id) {
        List<Event> eds = new ArrayList<>();

        String sql = "select * from events where employeeID = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eds.add(new Event(rs.getInt("id"),
                        rs.getInt("typeOfClass"),
                        rs.getString("nameOfClass"),
                        rs.getInt("costOfClass"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getInt("timeOfClass"),
                        rs.getString("about"),
                        rs.getString("justification"),
                        rs.getInt("employeeID"),
                        rs.getInt("managerID"),
                        rs.getString("gradeDescription"),
                        rs.getInt("gradeingFormat"),
                        rs.getString("finalGrade"),
                        rs.getBoolean("approved"),
                        rs.getString("fullForm"),
                        rs.getString("gradeOrPresentation")
                ));
            }
            return eds;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //@Override
    public List<Event> getAllEventsByManager(int id) {
        List<Event> eds = new ArrayList<>();

        String sql = "select * from events where managerID = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eds.add(new Event(rs.getInt("id"),
                        rs.getInt("typeOfClass"),
                        rs.getString("nameOfClass"),
                        rs.getInt("costOfClass"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getInt("timeOfClass"),
                        rs.getString("about"),
                        rs.getString("justification"),
                        rs.getInt("employeeID"),
                        rs.getInt("managerID"),
                        rs.getString("gradeDescription"),
                        rs.getInt("gradeingFormat"),
                        rs.getString("finalGrade"),
                        rs.getBoolean("approved"),
                        rs.getString("fullForm"),
                        rs.getString("gradeOrPresentation")
                ));
            }
            return eds;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Event create(Event event) {
        //todo string sql
        String sql = "with inserted_ed as (insert into events values (default, ?, ?, ?, ?, ?, ?) returning *)"
                + " select * from inserted_ed ie left join genres g on ie.genre_committee = g.id";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, event.getId());
            ps.setInt(2, event.getTypeOfClass());
            ps.setString(3, event.getNameOfClass());
            ps.setInt(4, event.getCostOfClass());
            ps.setInt(5, event.getStartDate());
            ps.setInt(6, event.getEndDate());
            ps.setInt(7, event.getTimeOfClass());
            ps.setString(8, event.getAbout());
            ps.setString(9, event.getJustification());
            ps.setInt(10, event.getEmployee());
            ps.setInt(11, event.getManager());
            ps.setString(12, event.getGradeDescription());
            ps.setInt(13, event.getGradingFormat());
            ps.setString(14, event.getFinalGrade());
            ps.setBoolean(15, event.isApproved());
            ps.setString(16, event.getFullForm());
            ps.setString(17, event.getGradeOrPresentation());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Event(
                        rs.getInt("id"),
                        rs.getInt("typeOfClass"),
                        rs.getString("nameOfClass"),
                        rs.getInt("costOfClass"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getInt("timeOfClass"),
                        rs.getString("about"),
                        rs.getString("justification"),
                        rs.getInt("employeeID"),
                        rs.getInt("managerID"),
                        rs.getString("gradeDescription"),
                        rs.getInt("gradeingFormat"),
                        rs.getString("finalGrade"),
                        rs.getBoolean("approved"),
                        rs.getString("fullForm"),
                        rs.getString("gradeOrPresentation")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Event eChanged) {
        //todo fixed a little but that where tho
        String sql = "update event set id = ?, typeOfClass = ?, nameOfClass = ?, costOfClass = ?, " +
                "startDate = ?, endDate = ?, timeOfClass = ?, about = ?, justification = ?," +
                "employeeID = ?, managerID = ?, gradeDescription = ?, gradeingFormat = ?," +
                "finalGrade = ?, approved = ?, fullForm = ?, gradeOrPresentation = ?" +
                " where id = ?";

        try (Connection conn = cu.getConnection()) {
            //todo
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, eChanged.getId());
            ps.setInt(2, eChanged.getTypeOfClass());
            ps.setString(3, eChanged.getNameOfClass());
            ps.setInt(4, eChanged.getCostOfClass());
            ps.setInt(5, eChanged.getStartDate());
            ps.setInt(6, eChanged.getEndDate());
            ps.setInt(7, eChanged.getTimeOfClass());
            ps.setString(8, eChanged.getAbout());
            ps.setString(9, eChanged.getJustification());
            ps.setInt(10, eChanged.getEmployee());
            ps.setInt(11, eChanged.getManager());
            ps.setString(12, eChanged.getGradeDescription());
            ps.setInt(13, eChanged.getGradingFormat());
            ps.setString(14, eChanged.getFinalGrade());
            ps.setBoolean(15, eChanged.isApproved());
            ps.setString(16, eChanged.getFullForm());
            ps.setString(17, eChanged.getGradeOrPresentation());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from events where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
