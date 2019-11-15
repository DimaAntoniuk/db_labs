package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.model.Price;
import ua.lviv.iot.service.PriceService;

import java.util.List;

@RestController
@RestMapping("/antoniuk_db")
public class PriceController implements Controller<Price> {
    @Autowired
    PriceService priceService;

    @Override
    @GetMapping("/price")
    public List<Price> getAll() {
        return priceService.getAll();
    }

    @Override
    @GetMapping("/price/{id}")
    public Price getById(@PathVariable Integer id) {
        return priceService.getById(id);
    }

    @Override
    @GetMapping("/price")
    public void create(@RequestBody Price price) {
        priceService.create(price);
    }

    @Override
    @GetMapping("/price/{id}")
    public void update(@PathVariable Integer id, @RequestBody Price price) {
        priceService.update(id, price);
    }

    @Override
    @GetMapping("/price/{id}")
    public void delete(Integer id) {

    }
}
