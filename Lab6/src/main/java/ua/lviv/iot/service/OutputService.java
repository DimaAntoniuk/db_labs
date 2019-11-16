package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.model.Output;
import ua.lviv.iot.repository.OutputRepository;

import java.util.List;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;

    public List<Output> getAll() {
        return outputRepository.findAll();
    }

    public Output getById(Integer id) {
        return outputRepository.findById(id).get();
    }

    @Transactional
    public void create(Output output) {
        outputRepository.save(output);
    }

    @Transactional
    public void update(Integer id, Output output) {
        if(outputRepository.findById(id).isPresent()) {
            Output oldOutput = outputRepository.findById(id).get();
            oldOutput.setPowerPerHour(output.getPowerPerHour());
            oldOutput.setTimeStart(output.getTimeStart());
            oldOutput.setTimeEnd(output.getTimeEnd());
            oldOutput.setPriceId(output.getPriceId());
            oldOutput.setStationId(oldOutput.getStationId());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if(outputRepository.findById(id).isPresent()) {
            outputRepository.deleteById(id);
        }
    }
}
