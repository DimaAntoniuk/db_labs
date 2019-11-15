package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.service.OwnerService;

import java.util.List;

@RestController
@RestMapping("/antoniuk_db")
public class OwnerController implements Controller<Owner> {
    @Autowired
    OwnerService ownerService;


    @Override
    @GetMappin("/owner")
    public List<Owner> getAll() {
        return ownerService.getAll();
    }

    @Override
    @GetMappin("/owner/{id}")
    public Owner getById(@PathVariable Integer id) {
        return ownerService.getById(id);
    }

    @Override
    @GetMappin("/owner")
    public void create(@RequestBody Owner owner) {
        ownerService.create(owner)
    }

    @Override
    @GetMappin("/owner/{id}")
    public void update(@PathVariable Integer id, @RequestBody Owner owner) {
        ownerService>update(id, owner);
    }

    @Override
    @GetMappin("/owner/{id}")
    public void delete(@PathVariable Integer id) {
        ownerService.delete(id);
    }
}
