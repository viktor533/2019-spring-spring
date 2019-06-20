package com.epam.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatController {
    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @RequestMapping(value = "/cat", method = RequestMethod.GET)
    public Cat getCat(@RequestParam(name = "catId", defaultValue = "1", required = true) Long id) {
        return catService.getCatById(id);
    }

}
