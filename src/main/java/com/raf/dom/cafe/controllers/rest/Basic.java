package com.raf.dom.cafe.controllers.rest;

import com.raf.dom.cafe.model.Coffee;
import com.raf.dom.cafe.services.CoffeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable Long id){
        coffeeRepo.deleteById(id);
        return new ModelAndView("redirect:/about");
    }


}
