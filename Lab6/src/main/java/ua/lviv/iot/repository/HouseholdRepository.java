package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Household;

public interface HouseholdRepository extends JpaRepository<Household, Integer> {
}
