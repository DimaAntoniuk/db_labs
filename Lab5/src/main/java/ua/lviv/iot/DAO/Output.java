package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class Output {
    private static final String FIND_ALL = "SELECT * FROM `output`";
    private static final String FIND_BY_ID = "SELECT * FROM `output` WHERE id=?";
    private static final String CREATE = "INSERT INTO `output` (power_per_hour, time_start, time_end, station_id, price_id)" +
            " VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `output` SET power_per_hour=?, time_start=?, time_end=?, price_id=?, station_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `output` WHERE id=?";

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

    public void create(Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, powerPerHour);
            ps.setDate(2, timeStart);
            ps.setDate(3, timeEnd);
            ps.setInt(4, stationId);
            ps.setInt(5, priceId);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, powerPerHour);
            ps.setDate(2, timeStart);
            ps.setDate(3, timeEnd);
            ps.setInt(4, stationId);
            ps.setInt(5, priceId);
            ps.setInt(6, id);

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
            System.out.print(", power_per_hour: " + resultSet.getString("power_per_hour"));
            System.out.print(", time_start: " + resultSet.getString("time_start"));
            System.out.print(", time_end: " + resultSet.getString("time_end"));
            System.out.print(", station_id: " + resultSet.getString("station_id"));
            System.out.print(", price_id: " + resultSet.getString("price_id"));
            System.out.println("}");
        }
    }
}
