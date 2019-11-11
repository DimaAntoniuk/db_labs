package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Station {
    private static final String FIND_ALL = "SELECT * FROM `station`";
    private static final String FIND_BY_ID = "SELECT * FROM `station` WHERE id=?";
    private static final String CREATE = "INSERT INTO `station` (number_of_panels, address, time_of_usage)" +
            " VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE `station` SET number_of_pannels=?, address=?, time_of_usage=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `station` WHERE id=?";

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

    public void create(Integer numberOfPanels, String address, Integer timeOfUsage) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, numberOfPanels);
            ps.setString(2, address);
            ps.setInt(3, timeOfUsage);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, Integer numberOfPanels, String address, Integer timeOfUsage) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, numberOfPanels);
            ps.setString(2, address);
            ps.setInt(3, timeOfUsage);
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
            System.out.print(", number_of_panels: " + resultSet.getInt("number_of_panels"));
            System.out.print(", address: " + resultSet.getString("address"));
            System.out.print(", time_of_usage: " + resultSet.getInt("time_of_usage"));
            System.out.println("}");
        }
    }
}
