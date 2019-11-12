package ua.lviv.iot.controller;

import ua.lviv.iot.model.*;
import ua.lviv.iot.services.BusinessLogic;
import ua.lviv.iot.services.BusinessLogicImpl;

import java.sql.Date;
import java.sql.Time;

public class ControllerImpl implements Controller {
    private BusinessLogic businessLogic;

    public ControllerImpl() {
        businessLogic = new BusinessLogicImpl();
    }

    @Override
    public void findAllHousehold() {
        businessLogic.findAllHousehold();
    }

    @Override
    public void findHouseholdById(Integer id) {
        businessLogic.findHouseholdById(id);
    }

    @Override
    public void createHousehold(String name) {
        businessLogic.createHousehold(new HouseholdEntity(name));
    }

    @Override
    public void updateHousehold(Integer id, String name) {
        businessLogic.updateHousehold(id, new HouseholdEntity(name));
    }

    @Override
    public void deleteHousehold(Integer id) {
        businessLogic.deleteHousehold(id);
    }

    @Override
    public void findAllOutput() {
        businessLogic.findAllOutput();
    }

    @Override
    public void findOutputById(Integer id) {
        businessLogic.findOutputById(id);
    }

    @Override
    public void createOutput(Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId) {
        businessLogic.createOutput(new OutputEntity(powerPerHour, timeStart, timeEnd, stationId, priceId));
    }

    @Override
    public void updateOutput(Integer id, Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId) {
        businessLogic.updateOutput(id, new OutputEntity(powerPerHour, timeStart, timeEnd, stationId, priceId));
    }

    @Override
    public void deleteOutput(Integer id) {
        businessLogic.deleteOutput(id);
    }

    @Override
    public void findAllOwner() {
        businessLogic.findAllOwner();
    }

    @Override
    public void findOwnerById(Integer id) {
        businessLogic.findOwnerById(id);
    }

    @Override
    public void createOwner(String firstName, String lastName) {
        businessLogic.createOwner(new OwnerEntity(firstName, lastName));
    }

    @Override
    public void updateOwner(Integer id, String firstName, String lastName) {
        businessLogic.updateOwner(id, new OwnerEntity(firstName, lastName));
    }

    @Override
    public void deleteOwner(Integer id) {
        businessLogic.deleteOwner(id);
    }

    @Override
    public void findAllPanel() {
        businessLogic.findAllPanel();
    }

    @Override
    public void findPanelById(Integer id) {
        businessLogic.findPanelById(id);
    }

    @Override
    public void createPanel(String type, Integer capacity, Integer stationId) {
        businessLogic.createPanel(new PanelEntity(type, capacity, stationId));
    }

    @Override
    public void updatePanel(Integer id, String type, Integer capacity, Integer stationId) {
        businessLogic.updatePanel(id, new PanelEntity(type, capacity, stationId));
    }

    @Override
    public void deletePanel(Integer id) {
        businessLogic.deletePanel(id);
    }

    @Override
    public void findAllPanelData() {
        businessLogic.findAllPanelData();
    }

    @Override
    public void findPanelDataById(Integer id) {
        businessLogic.findPanelDataById(id);
    }

    @Override
    public void createPanelData(Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId) {
        businessLogic.createPanelData(new PanelDataEntity(date, angle, power, chargeLevel, panelId));
    }

    @Override
    public void updatePanelData(Integer id, Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId) {
        businessLogic.updatePanelData(id, new PanelDataEntity(date, angle, power, chargeLevel, panelId));
    }

    @Override
    public void deletePanelData(Integer id) {
        businessLogic.deletePanelData(id);
    }

    @Override
    public void findAllPrice() {
        businessLogic.findAllPrice();
    }

    @Override
    public void findPriceById(Integer id) {
        businessLogic.findPriceById(id);
    }

    @Override
    public void createPrice(Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd) {
        businessLogic.createPrice(new PriceEntity(value, timeOfPriceBegin, timeOfPriceEnd));
    }

    @Override
    public void updatePrice(Integer id, Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd) {
        businessLogic.updatePrice(id, new PriceEntity(value, timeOfPriceBegin, timeOfPriceEnd));
    }

    @Override
    public void deletePrice(Integer id) {
        businessLogic.deletePrice(id);
    }

    @Override
    public void findAllStation() {
        businessLogic.findAllStation();
    }

    @Override
    public void findStationById(Integer id) {
        businessLogic.findStationById(id);
    }

    @Override
    public void createStation(Integer numberOfPanels, String address, Integer timeOfUsage) {
        businessLogic.createStation(new StationEntity(numberOfPanels, address, timeOfUsage));
    }

    @Override
    public void updateStation(Integer id, Integer numberOfPanels, String address, Integer timeOfUsage) {
        businessLogic.updateStation(id, new StationEntity(numberOfPanels, address, timeOfUsage));
    }

    @Override
    public void deleteStation(Integer id) {
        businessLogic.deleteStation(id);
    }

    @Override
    public void findAllOwnerHasStation() {
        businessLogic.findAllOwnerHasStation();
    }

    @Override
    public void findOwnerHasStationById(Integer ownerId, Integer stationId) {
        businessLogic.findOwnerHasStationById(ownerId, stationId);
    }

    @Override
    public void createOwnerHasStation(Integer ownerId, Integer stationId) {
        businessLogic.createOwnerHasStation(new OwnerHasStationEntity(ownerId, stationId));
    }

    @Override
    public void deleteOwnerHasStation(Integer ownerId, Integer stationId) {
        businessLogic.deleteOwnerHasStation(ownerId, stationId);
    }

    @Override
    public void findAllStationHasHousehold() {
        businessLogic.findAllStationHasHousehold();
    }

    @Override
    public void findStationHasHouseholdById(Integer stationId, Integer householdId) {
        businessLogic.findStationHasHouseholdById(stationId, householdId);
    }

    @Override
    public void createStationHasHousehold(Integer stationId, Integer householdId) {
        businessLogic.createStationHasHousehold(new StationHasHouseholdEntity(stationId, householdId));
    }

    @Override
    public void deleteStationHasHousehold(Integer stationId, Integer householdId) {
        businessLogic.deleteStationHasHousehold(stationId, householdId);
    }
}
