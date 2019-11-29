package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.model.PanelData;
import ua.lviv.iot.repository.PanelDataRepository;

import java.util.List;

@Service
public class PanelDataService {
    @Autowired
    PanelDataRepository panelDataRepository;

    public List<PanelData> getAll() {
        return panelDataRepository.findAll();
    }

    public PanelData getById(Integer id) {
        return panelDataRepository.findById(id).get();
    }

    @Transactional
    public void create(PanelData panelData) {
        panelDataRepository.save(panelData);
    }

    @Transactional
    public void update(Integer id, PanelData panelData) {
        if (panelDataRepository.findById(id).isPresent()) {
            PanelData oldPanelData = panelDataRepository.findById(id).get();
            oldPanelData.setAngle(panelData.getAngle());
            oldPanelData.setChargeLevel(panelData.getChargeLevel());
            oldPanelData.setDate(panelData.getDate());
            oldPanelData.setPower(panelData.getPower());
            oldPanelData.setPanelId(panelData.getPanelId());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if(panelDataRepository.findById(id).isPresent()) {
            panelDataRepository.deleteById(id);
        }
    }
}