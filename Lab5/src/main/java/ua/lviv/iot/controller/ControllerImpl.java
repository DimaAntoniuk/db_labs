package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.*;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class ControllerImpl implements Controller {
    private static Household household;
    private static Output output;
    private static Owner owner;
    private static Panel panel;
    private static PanelData panelData;
    private static Price price;
    private static Station station;
    private static OwnerHasStation ownerHasStation;
    private static StationHasHousehold stationHasHousehold;

    public ControllerImpl() {
        household = new Household();
        output = new Output();
        owner = new Owner();
        panel = new Panel();
        panelData = new PanelData();
        price = new Price();
        station = new Station();
        ownerHasStation = new OwnerHasStation();
        stationHasHousehold = new StationHasHousehold();
    }

    @Override
    public void findAllHousehold() throws SQLException {
        household.findAll();
    }

    @Override
    public void findHouseholdById(Integer id) throws SQLException {
        household.findById(id);
    }

    @Override
    public void createHousehold(String name) throws SQLException {
        household.create(name);
    }

    @Override
    public void updateHousehold(Integer id, String name) throws SQLException {
        household.update(id, name);
    }

    @Override
    public void deleteHousehold(Integer id) throws SQLException {
        household.delete(id);
    }

    @Override
    public void findAllOutput() throws SQLException {
        output.findAll();
    }

    @Override
    public void findOutputById(Integer id) throws SQLException {
        output.findById(id);
    }

    @Override
    public void createOutput(Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId) throws SQLException {
        output.create(powerPerHour, timeStart, timeEnd, stationId, priceId);
    }

    @Override
    public void updateOutput(Integer id, Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId) throws SQLException {
        output.update(id, powerPerHour, timeStart, timeEnd, stationId, priceId);
    }

    @Override
    public void deleteOutput(Integer id) throws SQLException {
        output.delete(id);
    }

    @Override
    public void findAllOwner() throws SQLException {
        owner.findAll();
    }

    @Override
    public void findOwnerById(Integer id) throws SQLException {
        owner.findById(id);
    }

    @Override
    public void createOwner(String firstName, String lastName) throws SQLException {
        owner.create(firstName, lastName);
    }

    @Override
    public void updateOwner(Integer id, String firstName, String lastName) throws SQLException {
        owner.update(id, firstName, lastName);
    }

    @Override
    public void deleteOwner(Integer id) throws SQLException {
        owner.delete(id);
    }

    @Override
    public void findAllPanel() throws SQLException {
        panel.findAll();
    }

    @Override
    public void findPanelById(Integer id) throws SQLException {
        panel.findById(id);
    }

    @Override
    public void createPanel(String type, Integer capacity, Integer stationId) throws SQLException {
        panel.create(type, capacity, stationId);
    }

    @Override
    public void updatePanel(Integer id, String type, Integer capacity, Integer stationId) throws SQLException {
        panel.update(id, type, capacity, stationId);
    }

    @Override
    public void deletePanel(Integer id) throws SQLException {
        panel.delete(id);
    }

    @Override
    public void findAllPanelData() throws SQLException {
        panelData.findAll();
    }

    @Override
    public void findPanelDataById(Integer id) throws SQLException {
        panelData.findById(id);
    }

    @Override
    public void createPanelData(Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId) throws SQLException {
        panelData.create(date, angle, power, chargeLevel, panelId);
    }

    @Override
    public void updatePanelData(Integer id, Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId) throws SQLException {
        panelData.update(id, date, angle, power, chargeLevel, panelId);
    }

    @Override
    public void deletePanelData(Integer id) throws SQLException {
        panelData.delete(id);
    }

    @Override
    public void findAllPrice() throws SQLException {
        price.findAll();
    }

    @Override
    public void findPriceById(Integer id) throws SQLException {
        price.findById(id);
    }

    @Override
    public void createPrice(Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd) throws SQLException {
        price.create(value, timeOfPriceBegin, timeOfPriceEnd);
    }

    @Override
    public void updatePrice(Integer id, Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd) throws SQLException {
        price.update(id, value, timeOfPriceBegin, timeOfPriceEnd);
    }

    @Override
    public void deletePrice(Integer id) throws SQLException {
        price.delete(id);
    }

    @Override
    public void findAllStation() throws SQLException {
        station.findAll();
    }

    @Override
    public void findStationById(Integer id) throws SQLException {
        station.findById(id);
    }

    @Override
    public void createStation(Integer numberOfPanels, String address, Integer timeOfUsage) throws SQLException {
        station.create(numberOfPanels, address, timeOfUsage);
    }

    @Override
    public void updateStation(Integer id, Integer numberOfPanels, String address, Integer timeOfUsage) throws SQLException {
        station.update(id, numberOfPanels, address, timeOfUsage);
    }

    @Override
    public void deleteStation(Integer id) throws SQLException {
        station.delete(id);
    }

    @Override
    public void findAllOwnerHasStation() throws SQLException {
        ownerHasStation.findAll();
    }

    @Override
    public void findOwnerHasStationById(Integer ownerId, Integer stationId) throws SQLException {
        ownerHasStation.findById(ownerId, stationId);
    }

    @Override
    public void createOwnerHasStation(Integer ownerId, Integer stationId) throws SQLException {
        ownerHasStation.create(ownerId, stationId);
    }

    @Override
    public void deleteOwnerHasStation(Integer ownerId, Integer stationId) throws SQLException {
        ownerHasStation.delete(ownerId, stationId);
    }

    @Override
    public void findAllStationHasHousehold() throws SQLException {
        stationHasHousehold.findAll();
    }

    @Override
    public void findStationHasHouseholdById(Integer stationId, Integer householdId) throws SQLException {
        stationHasHousehold.findById(stationId, householdId);
    }

    @Override
    public void createStationHasHousehold(Integer stationId, Integer householdId) throws SQLException {
        stationHasHousehold.create(stationId, householdId);
    }

    @Override
    public void deleteStationHasHousehold(Integer stationId, Integer householdId) throws SQLException {
        stationHasHousehold.delete(stationId, householdId);
    }
}
