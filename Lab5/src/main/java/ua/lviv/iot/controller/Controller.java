package ua.lviv.iot.controller;

import java.sql.Date;
import java.sql.Time;

public interface Controller {

    void findAllHousehold();

    void findHouseholdById(Integer id);

    void createHousehold(String name);

    void updateHousehold(Integer id, String name);

    void deleteHousehold(Integer id);

    void findAllOutput();

    void findOutputById(Integer id);

    void createOutput(Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId);

    void updateOutput(Integer id, Integer powerPerHour, Date timeStart, Date timeEnd, Integer stationId, Integer priceId);

    void deleteOutput(Integer id);

    void findAllOwner();

    void findOwnerById(Integer id);

    void createOwner(String firstName, String lastName);

    void updateOwner(Integer id, String firstName, String lastName);

    void deleteOwner(Integer id);

    void findAllPanel();

    void findPanelById(Integer id);

    void createPanel(String type, Integer capacity, Integer stationId);

    void updatePanel(Integer id, String type, Integer capacity, Integer stationId);

    void deletePanel(Integer id);

    void findAllPanelData();

    void findPanelDataById(Integer id);

    void createPanelData(Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId);

    void updatePanelData(Integer id, Date date, Integer angle, Integer power, Integer chargeLevel, Integer panelId);

    void deletePanelData(Integer id);

    void findAllPrice();

    void findPriceById(Integer id);

    void createPrice(Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd);

    void updatePrice(Integer id, Integer value, Time timeOfPriceBegin, Time timeOfPriceEnd);

    void deletePrice(Integer id);

    void findAllStation();

    void findStationById(Integer id);

    void createStation(Integer numberOfPanels, String address, Integer timeOfUsage);

    void updateStation(Integer id, Integer numberOfPanels, String address, Integer timeOfUsage);

    void deleteStation(Integer id);

    void findAllOwnerHasStation();

    void findOwnerHasStationById(Integer ownerId, Integer stationId);

    void createOwnerHasStation(Integer ownerId, Integer stationId);

    void deleteOwnerHasStation(Integer ownerId, Integer stationId);

    void findAllStationHasHousehold();

    void findStationHasHouseholdById(Integer stationId, Integer householdId);

    void createStationHasHousehold(Integer stationId, Integer householdId);

    void deleteStationHasHousehold(Integer stationId, Integer householdId);
}
