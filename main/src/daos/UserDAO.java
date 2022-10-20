package daos;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements daos.GenericDAO<User> {

    utils.ConnectionUtil cu = utils.ConnectionUtil.getConnectionUtil();

    @Override
    public User getById(int id) {
        String sql = "select * from users where id = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("managerID"),
                        rs.getBoolean("isManager"),
                        rs.getInt("pending"),
                        rs.getInt("awarded")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User getUserByUsername(String username) {
        String sql = "select * from users where username = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("managerID"),
                        rs.getBoolean("isManager"),
                        rs.getInt("pending"),
                        rs.getInt("awarded")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> eds = new ArrayList<>();

        String sql = "select * from users";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eds.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("managerID"),
                        rs.getBoolean("isManager"),
                        rs.getInt("pending"),
                        rs.getInt("awarded")
                ));
            }
            return eds;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //@Override
    public List<User> getEmployeesOfManager(int id) {
        List<User> eds = new ArrayList<>();

        String sql = "select * from users where manager = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eds.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("managerID"),
                        rs.getBoolean("isManager"),
                        rs.getInt("pending"),
                        rs.getInt("awarded")
                ));
            }
            return eds;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User create(User user) {
        //todo string sql
        String sql = "with inserted_ed as (insert into editors values (default, ?, ?, ?, ?, ?, ?) returning *)"
                + " select * from inserted_ed ie left join genres g on ie.genre_committee = g.id";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setInt(6, user.getManager());
            ps.setBoolean(7, user.getIsManager());
            ps.setInt(8, user.getPending());
            ps.setInt(9, user.getAwarded());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("managerID"),
                        rs.getBoolean("isManager"),
                        rs.getInt("pending"),
                        rs.getInt("awarded")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User eChanged) {
        //todo fixed a little but that where tho
        String sql = "update users set id = ?, username = ?, password = ?, firstName = ?, " +
                "lastName = ?, managerID = ?, isManager = ?, pending = ?, awarded = ?" +
                " where id = ?";

        try (Connection conn = cu.getConnection()) {
            //todo
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, eChanged.getId());
            ps.setString(2, eChanged.getUsername());
            ps.setString(3, eChanged.getPassword());
            ps.setString(4, eChanged.getFirstName());
            ps.setString(5, eChanged.getLastName());
            ps.setInt(6, eChanged.getManager());
            ps.setBoolean(7, eChanged.getIsManager());
            ps.setInt(8, eChanged.getPending());
            ps.setInt(9, eChanged.getAwarded());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from users where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
