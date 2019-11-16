package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Household;
import ua.lviv.iot.service.HouseholdService;

import java.util.List;

@RestController
@RequestMapping("/antoniuk_db")
public class HouseholdController implements Controller<Household> {
    @Autowired
    HouseholdService householdService;

    @Override
    @GetMapping("/household")
    public List<Household> getAll() {
        return householdService.getAll();
    }

    @Override
    @GetMapping("/household/{id}")
    public Household getById(@PathVariable Integer id) {
        return householdService.getById(id);
    }

    @Override
    @PostMapping("household")
    public void create(@RequestBody Household household) {
        householdService.create(household);
    }

    @Override
    @PutMapping("/household/{id}")
    public void update(@PathVariable Integer id, @RequestBody Household household) {
        householdService.update(id, household);
    }

    @Override
    @DeleteMapping("/household/{id}")
    public void delete(@PathVariable Integer id) {
        householdService.delete(id);
    }
}
