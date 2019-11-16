package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {
}
