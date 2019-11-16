package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Panel;

public interface PanelRepository extends JpaRepository<Panel, Integer> {
}
