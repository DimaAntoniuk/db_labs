package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/antoniuk_db")
public class OwnerController implements Controller<Owner> {
    @Autowired
    OwnerService ownerService;


    @Override
    @GetMapping("/owner")
    public List<Owner> getAll() {
        return ownerService.getAll();
    }

    @Override
    @GetMapping("/owner/{id}")
    public Owner getById(@PathVariable Integer id) {
        return ownerService.getById(id);
    }

    @Override
    @PostMapping("/owner")
    public void create(@RequestBody Owner owner) {
        ownerService.create(owner);
    }

    @Override
    @PutMapping("/owner/{id}")
    public void update(@PathVariable Integer id, @RequestBody Owner owner) {
        ownerService.update(id, owner);
    }

    @Override
    @DeleteMapping("/owner/{id}")
    public void delete(@PathVariable Integer id) {
        ownerService.delete(id);
    }
}
