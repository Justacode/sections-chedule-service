package ru.kpfu.itis.mustafin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.mustafin.models.City;
import ru.kpfu.itis.mustafin.repositories.CityRepository;
import ru.kpfu.itis.mustafin.services.CityService;
import ru.kpfu.itis.mustafin.services.impl.CityServiceImpl;

import java.util.List;

@Controller
public class MainController {

    private final CityService cityService;

    @Autowired
    public MainController(CityService cityService){
        this.cityService = cityService;
    }

    @RequestMapping("/home")
    public String home(Model model){
        List<City> city = cityService.getAll();
        model.addAttribute("city", city.get(0));
        return "home";
    }

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
}
