package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.PanelData;

public interface PanelDataRepository extends JpaRepository<PanelData, Integer> {
}