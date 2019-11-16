package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Output;
import ua.lviv.iot.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/antoniuk_db")
public class OutputController implements Controller<Output> {
    @Autowired
    OutputService outputService;

    @Override
    @GetMapping("/output")
    public List<Output> getAll() {
        return outputService.getAll();
    }

    @Override
    @GetMapping("/output/{id}")
    public Output getById(@PathVariable Integer id) {
        return outputService.getById(id);
    }

    @Override
    @GetMapping("/output")
    public void create(@RequestBody Output output) {
        outputService.create(output);
    }

    @Override
    @GetMapping("/output/{id}")
    public void update(@PathVariable Integer id, @RequestBody Output output) {
        outputService.update(id, output);
    }

    @Override
    @GetMapping("/output/{id}")
    public void delete(@PathVariable Integer id) {
        outputService.delete(id);
    }
}
