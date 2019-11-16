package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.StationHasHouseholdPK;

public interface StationHasHousehold extends JpaRepository<StationHasHousehold, StationHasHouseholdPK> {
}
