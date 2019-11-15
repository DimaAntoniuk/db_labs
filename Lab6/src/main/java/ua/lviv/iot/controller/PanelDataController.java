package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.model.PanelData;
import ua.lviv.iot.service.PanelDataService;

import java.util.List;

@RestController
@RestMapping("/antoniuk_db")
public class PanelDataController implements Controller<PanelData> {
    @Autowired
    PanelDataService panelDataService;

    @Override
    @GetMappin("/panel_data")
    public List<PanelData> getAll() {
        return panelDataService.gatAll();
    }

    @Override
    @GetMappin("/panel_data/{id}")
    public PanelData getById(@PathVariable Integer id) {
        return panelDataService.getById(id);
    }

    @Override
    @GetMappin("/panel_data")
    public void create(@RequestBody PanelData panelData) {
        panelData.create(panelData);
    }

    @Override
    @GetMappin("/panel_data/{id}")
    public void update(@PathVariable Integer id, @RequestBody PanelData panelData) {
        panelData.update(id, panelData);
    }

    @Override
    @GetMappin("/panel_data/{id}")
    public void delete(@PathVatiable Integer id) {
        panelDataService.delete(id);
    }
}
