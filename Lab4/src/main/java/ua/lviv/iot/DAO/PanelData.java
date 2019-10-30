package ua.lviv.iot.DAO;

import ua.lviv.iot.connection.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class PanelData {
    private static final String FIND_ALL = "SELECT * FROM `panel_data`";
    private static final String FIND_BY_ID = "SELECT * FROM `panel_data` WHERE id=?";
    private static final String CREATE = "INSERT INTO `panel_data` (`date`, angle, power, chrge_level, panel_id)" +
            " VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `panel_data` SET `date`=?, angle=?, power=?, chrge_level=?, panel_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `panel_data` WHERE id=?";

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

    public void create(Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setDate(1, date);
            ps.setInt(2, angle);
            ps.setInt(3, power);
            ps.setInt(4, chargeLevel);
            ps.setInt(5, panelId);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setDate(1, date);
            ps.setInt(2, angle);
            ps.setInt(3, power);
            ps.setInt(4, chargeLevel);
            ps.setInt(5, panelId);
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
            System.out.print(", date: " + resultSet.getDate("date"));
            System.out.print(", angle: " + resultSet.getInt("angle"));
            System.out.print(", power: " + resultSet.getInt("power"));
            System.out.print(", charge_level: " + resultSet.getInt("charge_level"));
            System.out.print(", panel_id: " + resultSet.getInt("panel_id"));
            System.out.println("}");
        }
    }
}
