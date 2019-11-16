package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.OwnerHasStation;
import ua.lviv.iot.model.OwnerHasStationPK;

public interface OwnerHasStationRepository extends JpaRepository<OwnerHasStation, OwnerHasStationPK> {
}
