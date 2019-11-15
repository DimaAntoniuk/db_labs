package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.model.Household;
import ua.lviv.iot.service.HouseholdService;

import java.util.List;

@RestController
@RestMapping("/antoniuk_db")
public class HouseholdController implements Controller<Household> {
    @Autowired
    HouseholdService householdService;

    @Override
    @GetMappin("/household")
    public List<Household> getAll() {
        return householdService.getAll();
    }

    @Override
    @GetMappin("/household/{id}")
    public Household getById(@PathVariabe Integer id) {
        return householdService.getById(id);
    }

    @Override
    @GetMappin("household")
    public void create(@RequestBody Household household) {
        householdService.create(household)
    }

    @Override
    @GetMappin("/household/{id}")
    public void update(@PathVariabel Integer id, @RequestBody Household household) {
        householdService.update(id, household);
    }

    @Override
    @GetMappin("/household/{id}")
    public void delete(@pathVariale Integer id) {
        householdService.delete(id);
    }
}
