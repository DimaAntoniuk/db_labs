package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerHasStation {
    private static final String FIND_ALL = "SELECT * FROM `owner_has_station`";
    private static final String FIND_BY_ID = "SELECT * FROM `owner_has_station` WHERE owner_id=? AND station_id=?";
    private static final String CREATE = "INSERT INTO `owner_has_station` (owner_id, sation_id)" +
            " VALUES (?, ?)";
    private static final String DELETE = "DELETE FROM `owner_has_station` WHERE owner_id=? AND station_id=?";

    public void findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                print(resultSet);
            }
        }
    }

    public void findById(Integer ownerId, Integer stationId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, ownerId);
            ps.setInt(2, stationId);
            try (ResultSet resultSet = ps.executeQuery()) {
                print(resultSet);
            }
        }
    }

    public void create(Integer ownerId, Integer stationId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, ownerId);
            ps.setInt(2, stationId);

            ps.executeUpdate();
        }
    }

    public void delete(Integer ownerId, Integer stationId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, ownerId);
            ps.setInt(2, stationId);

            ps.executeUpdate();
        }
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("{owner_id: " + resultSet.getInt("owner_id"));
            System.out.print(", station_id: " + resultSet.getString("station_id"));
            System.out.println("}");
        }
    }
}
