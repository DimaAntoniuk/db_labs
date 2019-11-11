package ua.lviv.iot.services;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public interface BusinessLogic {
    void findAllHousehold() throws SQLException;

    void findHouseholdById(Integer id) throws SQLException;

    void createHousehold(String name) throws SQLException;

    void updateHousehold(Integer id, String name) throws SQLException;

    void deleteHousehold(Integer id) throws SQLException;

    void findAllOutput() throws SQLException;

    void findOutputById(Integer id) throws SQLException;

    void createOutput(Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId) throws SQLException;

    void updateOutput(Integer id, Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId) throws SQLException;

    void deleteOutput(Integer id) throws SQLException;

    void findAllOwner() throws SQLException;

    void findOwnerById(Integer id) throws SQLException;

    void createOwner(String firstName, String lastName) throws SQLException;

    void updateOwner(Integer id, String firstName, String lastName) throws SQLException;

    void deleteOwner(Integer id) throws SQLException;

    void findAllPanel() throws SQLException;

    void findPanelById(Integer id) throws SQLException;

    void createPanel(String type, Integer capacity, Integer stationId) throws SQLException;

    void updatePanel(Integer id, String type, Integer capacity, Integer stationId) throws SQLException;

    void deletePanel(Integer id) throws SQLException;

    void findAllPanelData() throws SQLException;

    void findPanelDataById(Integer id) throws SQLException;

    void createPanelData(Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId) throws SQLException;

    void updatePanelData(Integer id, Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId) throws SQLException;

    void deletePanelData(Integer id) throws SQLException;

    void findAllPrice() throws SQLException;

    void findPriceById(Integer id) throws SQLException;

    void createPrice(Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd) throws SQLException;

    void updatePrice(Integer id, Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd) throws SQLException;

    void deletePrice(Integer id) throws SQLException;

    void findAllStation() throws SQLException;

    void findStationById(Integer id) throws SQLException;

    void createStation(Integer numberOfPanels, String address, Integer timeOfUsage) throws SQLException;

    void updateStation(Integer id, Integer numberOfPanels, String address, Integer timeOfUsage) throws SQLException;

    void deleteStation(Integer id) throws SQLException;

    void findAllOwnerHasStation() throws SQLException;

    void findOwnerHasStationById(Integer ownerId, Integer stationId) throws SQLException;

    void createOwnerHasStation(Integer ownerId, Integer stationId) throws SQLException;

    void deleteOwnerHasStation(Integer ownerId, Integer stationId) throws SQLException;

    void findAllStationHasHousehold() throws SQLException;

    void findStationHasHouseholdById(Integer stationId, Integer householdId) throws SQLException;

    void createStationHasHousehold(Integer stationId, Integer householdId) throws SQLException;

    void deleteStationHasHousehold(Integer stationId, Integer householdId) throws SQLException;
}
