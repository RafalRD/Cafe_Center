package com.raf.dom.cafe.controller.rest;

import com.raf.dom.cafe.model.Coffee;
import com.raf.dom.cafe.services.CoffeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Basic {

    @Autowired
    private CoffeeRepo coffeeRepo;

    @GetMapping("/show")
    public List<Coffee> show(){
        return coffeeRepo.findAll();
    }

    @GetMapping("show/{name}")
    public Coffee findByName(@PathVariable String name){
        return coffeeRepo.findByName(name);
    }

    @PostMapping("/add")
    public void add(@RequestBody Coffee coffee){
        coffeeRepo.save(coffee);
    }



}
