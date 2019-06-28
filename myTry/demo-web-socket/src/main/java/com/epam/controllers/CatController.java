package com.epam.controllers;

import com.epam.domain.Cat;
import com.epam.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {

    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping
    public Cat create(@RequestBody Cat cat) {
        return catService.create(cat);
    }

    @GetMapping("/{id}")
    public Cat get(@PathVariable Long id) {
        return catService.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        catService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Cat> getAll() {
        return (List<Cat>)catService.getAll();
    }
}
