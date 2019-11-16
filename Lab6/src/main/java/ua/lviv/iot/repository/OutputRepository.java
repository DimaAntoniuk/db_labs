package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Output;

public interface OutputRepository extends JpaRepository<Output, Integer> {
}
