package com.raf.dom.cafe.controllers.htmlPages;

import com.raf.dom.cafe.model.Coffee;
import com.raf.dom.cafe.services.CoffeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AboutPageMethods {

    @Autowired
    private CoffeeRepo coffeeRepo;

//    @GetMapping("/login")
//    public String courierLogin(){
//        return "login";
//    }


    @PostMapping("/save")
    public String save(@ModelAttribute @Valid Coffee coffee, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("coffee",coffee);
            return "about";
        }

        model.addAttribute("coffee",coffee);
        coffeeRepo.save(coffee);

        return "redirect:about";
    }
}
