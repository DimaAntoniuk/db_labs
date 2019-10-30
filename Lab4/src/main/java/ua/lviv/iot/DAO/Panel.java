package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Panel {
    private static final String FIND_ALL = "SELECT * FROM `panel`";
    private static final String FIND_BY_ID = "SELECT * FROM `panel` WHERE id=?";
    private static final String CREATE = "INSERT INTO `panel` (`type`, capacity, station_id)" +
            " VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE `panel` SET `type`=?, capacity=?, station_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `panel` WHERE id=?";

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

    public void create(String type, Integer capacity, Integer stationId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, type);
            ps.setInt(2, capacity);
            ps.setInt(3, stationId);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, String type, Integer capacity, Integer stationId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, type);
            ps.setInt(2, capacity);
            ps.setInt(3, stationId);
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
            System.out.print(", type: " + resultSet.getString("type"));
            System.out.print(", capacity: " + resultSet.getInt("capacity"));
            System.out.print(", station_id: " + resultSet.getInt("station_id"));
            System.out.println("}");
        }
    }
}
