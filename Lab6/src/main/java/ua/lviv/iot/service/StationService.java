package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.model.Station;
import ua.lviv.iot.repository.StationRepository;

import java.util.List;

@Service
public class StationService {
    @Autowired
    StationRepository stationRepository;

    public List<Station> getAll() {
        return stationRepository.findAll();
    }

    public Station getById(Integer id) {
        return stationRepository.findById(id).get();
    }

    @Transactional
    public void create(Station station) {
        stationRepository.save(station);
    }

    @Transactional
    public void update(Integer id, Station station) {
        if(stationRepository.findById(id).isPresent()) {
            Station oldStation = stationRepository.findById(id).get();
            oldStation.setAddress(station.getAddress());
            oldStation.setNumberOfPanels(station.getNumberOfPanels());
            oldStation.setTimeOfUsage(station.getTimeOfUsage());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if(stationRepository.findById(id).isPresent()) {
            stationRepository.deleteById(id);
        }
    }
}
