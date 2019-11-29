package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.PanelData;
import ua.lviv.iot.service.PanelDataService;

import java.util.List;

@RestController
@RequestMapping("/antoniuk_db")
public class PanelDataController implements Controller<PanelData> {
    @Autowired
    PanelDataService panelDataService;

    @Override
    @GetMapping("/panel_data")
    public List<PanelData> getAll() {
        return panelDataService.getAll();
    }

    @Override
    @GetMapping("/panel_data/{id}")
    public PanelData getById(@PathVariable Integer id) {
        return panelDataService.getById(id);
    }

    @Override
    @PostMapping("/panel_data")
    public void create(@RequestBody PanelData panelData) {
        panelDataService.create(panelData);
    }

    @Override
    @PutMapping("/panel_data/{id}")
    public void update(@PathVariable Integer id, @RequestBody PanelData panelData) {
        panelDataService.update(id, panelData);
    }

    @Override
    @DeleteMapping("/panel_data/{id}")
    public void delete(@PathVariable Integer id) {
        panelDataService.delete(id);
    }
}