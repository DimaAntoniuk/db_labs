package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Panel;
import ua.lviv.iot.service.PanelService;

import java.util.List;

@RestController
@RequestMapping("/antoniuk_db")
public class PanelController implements Controller<Panel> {
    @Autowired
    PanelService panelService;

    @Override
    @GetMapping("/panel")
    public List<Panel> getAll() {
        return panelService.getAll();
    }

    @Override
    @GetMapping("/panel/{id}")
    public Panel getById(@PathVariable Integer id) {
        return panelService.getById(id);
    }

    @Override
    @PostMapping("/panel")
    public void create(@RequestBody Panel panel) {
        panelService.create(panel);
    }

    @Override
    @PutMapping("/panel/{id}")
    public void update(@PathVariable Integer id, @RequestBody Panel panel) {
        panelService.update(id, panel);
    }

    @Override
    @DeleteMapping("/panel/{id}")
    public void delete(@PathVariable Integer id) {
        panelService.delete(id);
    }
}
