package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Price;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}
