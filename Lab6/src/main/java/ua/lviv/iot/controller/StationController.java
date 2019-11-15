package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.model.Station;

import java.util.List;

@RestController
@RestMapping("/antoniuk_db")
public class StationController implements Controller<Station> {
    @Autowired
    StationService stationService;

    @Override
    @GetMapping("/station")
    public List<Station> getAll() {
        return stationService.getAll();
    }

    @Override
    @GetMaping("/station/{id}")
    public Station getById(@PathVariable Integer id) {
        return stationService.getById(id);
    }

    @Override
    @GetMapping("/station")
    public void create(@RequestBody Station station) {
        stationService.create(station);
    }

    @Override
    @GetMapping("station/{id}")
    public void update(@PathVariable Integer id, @RequestBody Station station) {
        stationService.update(id, station);
    }

    @Override
    @GetMapping("station/{id}")
    public void delete(@PathVariable Integer id) {
        stationService.delete(id);
    }
}