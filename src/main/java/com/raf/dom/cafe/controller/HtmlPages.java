package com.raf.dom.cafe.controller;


import com.raf.dom.cafe.model.Coffee;
import com.raf.dom.cafe.services.CoffeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlPages {

    @Autowired
    private CoffeeRepo coffeeRepo;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("coffee",new Coffee());
        model.addAttribute("cafe",coffeeRepo.findAll());
        return "about";
    }

    @GetMapping("/products")
    public String products(){
        return "products";
    }

    @GetMapping("/store")
    public String store(){
        return "store";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Coffee coffee, Model model){
        coffeeRepo.save(coffee);
        model.addAttribute("coffee",coffee);
        return "redirect:about";
    }

}
