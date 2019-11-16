package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.model.Household;
import ua.lviv.iot.repository.HouseholdRepository;

import java.util.List;

@Service
public class HouseholdService {
    @Autowired
    HouseholdRepository householdRepository;

    public List<Household> getAll() {
        return householdRepository.findAll();
    }

    public Household getById(Integer id) {
        return householdRepository.findById(id).get();
    }

    @Transactional
    public void create(Household household) {
        householdRepository.save(household);
    }

    @Transactional
    public void update(Integer id, Household household) {
        if(householdRepository.findById(id).isPresent()) {
            Household oldHousehold = householdRepository.findById(id).get();
            oldHousehold.setName(household.getName());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if(householdRepository.findById(id).isPresent()) {
            householdRepository.deleteById(id);
        }
    }
}
