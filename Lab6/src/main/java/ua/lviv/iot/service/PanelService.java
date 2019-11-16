package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.model.Panel;
import ua.lviv.iot.repository.PanelRepository;

import java.util.List;

@Service
public class PanelService {
    @Autowired
    PanelRepository panelRepository;

    public List<Panel> getAll() {
        return panelRepository.findAll();
    }

    public Panel getById(Integer id) {
        return panelRepository.findById(id).get();
    }

    @Transactional
    public void create(Panel panel) {
        panelRepository.save(panel);
    }

    @Transactional
    public void update(Integer id, Panel panel) {
        if(panelRepository.findById(id).isPresent()) {
            Panel oldPanel = panelRepository.findById(id).get();
            oldPanel.setCapacity(panel.getCapacity());
            oldPanel.setType(panel.getType());
            oldPanel.setStationId(panel.getStationId());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if(panelRepository.findById(id).isPresent()) {
            panelRepository.deleteById(id);
        }
    }
}
