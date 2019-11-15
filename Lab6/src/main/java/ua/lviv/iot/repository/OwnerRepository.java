package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
