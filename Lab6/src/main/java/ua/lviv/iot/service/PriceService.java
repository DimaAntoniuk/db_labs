package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.model.Price;
import ua.lviv.iot.repository.PriceRepository;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    PriceRepository priceRepository;

    public List<Price> getAll() {
        return priceRepository.findAll();
    }

    public Price getById(Integer id) {
        return priceRepository.findById(id).get();
    }

    @Transactional
    public void create(Price price) {
        priceRepository.save(price);
    }

    @Transactional
    public void update(Integer id, Price price) {
        if(priceRepository.findById(id).isPresent()) {
            Price oldPrice = priceRepository.findById(id).get();
            oldPrice.setValue(price.getValue());
            oldPrice.setTimeOfPriceBegin(price.getTimeOfPriceBegin());
            oldPrice.setTimeOfPriceEnd(price.getTimeOfPriceEnd());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if(priceRepository.findById(id).isPresent()) {
            priceRepository.deleteById(id);
        }
    }
}
