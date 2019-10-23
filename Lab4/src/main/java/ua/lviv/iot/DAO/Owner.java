package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Owner {
    private static final String FIND_ALL = "SELECT * FROM `owner`";
    private static final String FIND_BY_ID = "SELECT * FROM `owner` WHERE client_id=?";
    private static final String CREATE = "INSERT INTO `owner` (id, first_name, last_name)" +
            " VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE `owner` SET username=?, password=?, email=? WHERE client_id=?";
    private static final String DELETE = "DELETE FROM `owner` WHERE id=?";

    public void findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                print(resultSet);
            }
        }
    }

    public void findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                print(resultSet);
            }
        }
    }

    public void create(Integer id, String firstName, String lastName) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, String firstName, String lastName) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(4, id);

            ps.executeUpdate();
        }
    }

    public void delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("{id: " + resultSet.getInt("id"));
            System.out.print(", first_name: " + resultSet.getString("first_name"));
            System.out.print(", last_name: " + resultSet.getString("last_name"));
            System.out.println("}");
        }
    }
}