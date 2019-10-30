package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class StationHasHousehold {
    private static final String FIND_ALL = "SELECT * FROM `station_has_household`";
    private static final String FIND_BY_ID = "SELECT * FROM `station_has_household` WHERE owner_id=? AND station_id=?";
    private static final String CREATE = "INSERT INTO `station_has_household` (station_id, household_id)" +
            " VALUES (?, ?)";
    private static final String DELETE = "DELETE FROM `station_has_household` WHERE station_id=? AND household_id=?";

    public void findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                print(resultSet);
            }
        }
    }

    public void findById(Integer stationId, Integer householdId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, stationId);
            ps.setInt(2, householdId);

            try (ResultSet resultSet = ps.executeQuery()) {
                print(resultSet);
            }
        }
    }

    public void create(Integer stationId, Integer householdId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, stationId);
            ps.setInt(2, householdId);

            ps.executeUpdate();
        }
    }

    public void delete(Integer stationId, Integer householdId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, stationId);
            ps.setInt(2, householdId);

            ps.executeUpdate();
        }
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("{station_id: " + resultSet.getInt("station_id"));
            System.out.print(", household_id: " + resultSet.getString("household_id"));
            System.out.println("}");
        }
    }
}
