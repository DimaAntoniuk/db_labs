package ua.lviv.iot.services;

import ua.lviv.iot.model.*;


public interface BusinessLogic {
    void findAllHousehold();
    void findHouseholdById(Integer id);
    void createHousehold(HouseholdEntity newItem);
    void updateHousehold(Integer id, HouseholdEntity newItem);
    void deleteHousehold(Integer id);

    void findAllOutput();
    void findOutputById(Integer id);
    void createOutput(OutputEntity newItem);
    void updateOutput(Integer id, OutputEntity newItem);
    void deleteOutput(Integer id);

    void findAllOwner();
    void findOwnerById(Integer id);
    void createOwner(OwnerEntity newItem);
    void updateOwner(Integer id, OwnerEntity newItem);
    void deleteOwner(Integer id);

    void findAllPanel();
    void findPanelById(Integer id);
    void createPanel(PanelEntity newItem);
    void updatePanel(Integer id, PanelEntity newItem);
    void deletePanel(Integer id);

    void findAllPanelData();
    void findPanelDataById(Integer id);
    void createPanelData(PanelDataEntity newItem);
    void updatePanelData(Integer id, PanelDataEntity newItem);
    void deletePanelData(Integer id);

    void findAllPrice();
    void findPriceById(Integer id);
    void createPrice(PriceEntity newItem);
    void updatePrice(Integer id, PriceEntity newItem);
    void deletePrice(Integer id);

    void findAllStation();
    void findStationById(Integer id);
    void createStation(StationEntity newItem);
    void updateStation(Integer id, StationEntity newItem);
    void deleteStation(Integer id);

    void findAllOwnerHasStation();
    void findOwnerHasStationById(Integer ownerId, Integer stationId);
    void createOwnerHasStation(OwnerHasStationEntity newItem);
    void deleteOwnerHasStation(Integer ownerId, Integer stationId);

    void findAllStationHasHousehold();
    void findStationHasHouseholdById(Integer stationId, Integer householdId);
    void createStationHasHousehold(StationHasHouseholdEntity newItem);
    void deleteStationHasHousehold(Integer stationId, Integer householdId) ;
}
