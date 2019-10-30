package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class Price {
    private static final String FIND_ALL = "SELECT * FROM `price`";
    private static final String FIND_BY_ID = "SELECT * FROM `price` WHERE id=?";
    private static final String CREATE = "INSERT INTO `price` (`value`, time_of_price_begin, time_of_price_end)" +
            " VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE `price` SET `value`=?, time_of_price_begin=?, time_of_price_end=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `price` WHERE id=?";

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

    public void create(Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, value);
            ps.setTime(2, timeOfPriceBegin);
            ps.setTime(3, timeOfPriceEnd);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, value);
            ps.setTime(2, timeOfPriceBegin);
            ps.setTime(3, timeOfPriceEnd);
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
            System.out.print(", value: " + resultSet.getInt("value"));
            System.out.print(", time_of_price_begin: " + resultSet.getTime("time_of_price_begin"));
            System.out.print(", time_of_price_end: " + resultSet.getTime("time_of_price_end"));
            System.out.println("}");
        }
    }
}
