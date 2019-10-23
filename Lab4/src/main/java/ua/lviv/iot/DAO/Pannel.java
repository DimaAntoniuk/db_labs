package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class Pannel {
    private static final String FIND_ALL = "SELECT * FROM `pannel`";
    private static final String FIND_BY_ID = "SELECT * FROM `pannel` WHERE id=?";
    private static final String CREATE = "INSERT INTO `pannel` (id, `type`, capacity, station_id)" +
            " VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `pannel` SET `type`=?, capacity=?, station_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `pannel` WHERE id=?";

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

    public void create(Integer id, String type, Integer capacity, Integer stationId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setString(2, type);
            ps.setInt(3, capacity);
            ps.setInt(4, stationId);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, String type, Integer capacity, Integer stationId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, id);
            ps.setString(2, type);
            ps.setInt(3, capacity);
            ps.setInt(4, stationId);

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
            System.out.print(", stationId: " + resultSet.getInt("stationId"));
            System.out.println("}");
        }
    }
}