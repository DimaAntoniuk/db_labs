package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Price;
import ua.lviv.iot.service.PriceService;

import java.util.List;

@RestController
@RequestMapping("/antoniuk_db")
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
    @PostMapping("/price")
    public void create(@RequestBody Price price) {
        priceService.create(price);
    }

    @Override
    @PutMapping("/price/{id}")
    public void update(@PathVariable Integer id, @RequestBody Price price) {
        priceService.update(id, price);
    }

    @Override
    @DeleteMapping("/price/{id}")
    public void delete(@PathVariable Integer id) {

    }
}
