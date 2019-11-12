package ua.lviv.iot.services;

import ua.lviv.iot.DAO.*;
import ua.lviv.iot.model.*;

public class BusinessLogicImpl implements BusinessLogic {
    private static HouseholdDAO household;
    private static OutputDAO output;
    private static OwnerDAO owner;
    private static PanelDAO panel;
    private static PanelDataDAO panelData;
    private static PriceDAO price;
    private static StationDAO station;
    private static OwnerHasStationDAO ownerHasStation;
    private static StationHasHouseholdDAO stationHasHousehold;

    public BusinessLogicImpl() {
        household = new HouseholdDAO();
        output = new OutputDAO();
        owner = new OwnerDAO();
        panel = new PanelDAO();
        panelData = new PanelDataDAO();
        price = new PriceDAO();
        station = new StationDAO();
        ownerHasStation = new OwnerHasStationDAO();
        stationHasHousehold = new StationHasHouseholdDAO();
    }

    @Override
    public void findAllHousehold() {
        household.findAll();
    }

    @Override
    public void findHouseholdById(Integer id) {
        household.findById(id);
    }

    @Override
    public void createHousehold(HouseholdEntity newItem) {
        household.create(newItem);
    }

    @Override
    public void updateHousehold(Integer id, HouseholdEntity newItem) {
        household.update(id, newItem);
    }

    @Override
    public void deleteHousehold(Integer id) {
        household.delete(id);
    }

    @Override
    public void findAllOutput() {
        output.findAll();
    }

    @Override
    public void findOutputById(Integer id) {
        output.findById(id);
    }

    @Override
    public void createOutput(OutputEntity newItem) {
        output.create(newItem);
    }

    @Override
    public void updateOutput(Integer id, OutputEntity newItem) {
        output.update(id, newItem);
    }

    @Override
    public void deleteOutput(Integer id) {
        output.delete(id);
    }

    @Override
    public void findAllOwner() {
        owner.findAll();
    }

    @Override
    public void findOwnerById(Integer id) {
        owner.findById(id);
    }

    @Override
    public void createOwner(OwnerEntity newItem) {
        owner.create(newItem);
    }

    @Override
    public void updateOwner(Integer id, OwnerEntity newItem) {
        owner.update(id, newItem);
    }

    @Override
    public void deleteOwner(Integer id) {
        owner.delete(id);
    }

    @Override
    public void findAllPanel() {
        panel.findAll();
    }

    @Override
    public void findPanelById(Integer id) {
        panel.findById(id);
    }

    @Override
    public void createPanel(PanelEntity newItem) {
        panel.create(newItem);
    }

    @Override
    public void updatePanel(Integer id, PanelEntity newItem) {
        panel.update(id, newItem);
    }

    @Override
    public void deletePanel(Integer id) {
        panel.delete(id);
    }

    @Override
    public void findAllPanelData() {
        panelData.findAll();
    }

    @Override
    public void findPanelDataById(Integer id) {
        panelData.findById(id);
    }

    @Override
    public void createPanelData(PanelDataEntity newItem) {
        panelData.create(newItem);
    }

    @Override
    public void updatePanelData(Integer id, PanelDataEntity newItem) {
        panelData.update(id, newItem);
    }

    @Override
    public void deletePanelData(Integer id) {
        panelData.delete(id);
    }

    @Override
    public void findAllPrice() {
        price.findAll();
    }

    @Override
    public void findPriceById(Integer id) {
        price.findById(id);
    }

    @Override
    public void createPrice(PriceEntity newItem) {
        price.create(newItem);
    }

    @Override
    public void updatePrice(Integer id, PriceEntity newItem) {
        price.update(id, newItem);
    }

    @Override
    public void deletePrice(Integer id) {
        price.delete(id);
    }

    @Override
    public void findAllStation() {
        station.findAll();
    }

    @Override
    public void findStationById(Integer id) {
        station.findById(id);
    }

    @Override
    public void createStation(StationEntity newItem) {
        station.create(newItem);
    }

    @Override
    public void updateStation(Integer id, StationEntity newItem) {
        station.update(id, newItem);
    }

    @Override
    public void deleteStation(Integer id) {
        station.delete(id);
    }

    @Override
    public void findAllOwnerHasStation() {
        ownerHasStation.findAll();
    }

    @Override
    public void findOwnerHasStationById(Integer ownerId, Integer stationId) {
        ownerHasStation.findById(ownerId, stationId);
    }

    @Override
    public void createOwnerHasStation(OwnerHasStationEntity newItem) {
        ownerHasStation.create(newItem);
    }

    @Override
    public void deleteOwnerHasStation(Integer ownerId, Integer stationId) {
        ownerHasStation.delete(ownerId, stationId);
    }

    @Override
    public void findAllStationHasHousehold() {
        stationHasHousehold.findAll();
    }

    @Override
    public void findStationHasHouseholdById(Integer stationId, Integer householdId) {
        stationHasHousehold.findById(stationId, householdId);
    }

    @Override
    public void createStationHasHousehold(StationHasHouseholdEntity newItem) {
        stationHasHousehold.create(newItem);
    }

    @Override
    public void deleteStationHasHousehold(Integer stationId, Integer householdId) {
        stationHasHousehold.delete(stationId, householdId);
    }
}
