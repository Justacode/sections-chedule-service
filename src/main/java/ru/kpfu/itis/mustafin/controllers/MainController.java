package ru.kpfu.itis.mustafin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.mustafin.models.*;
import ru.kpfu.itis.mustafin.repositories.CityRepository;
import ru.kpfu.itis.mustafin.services.*;
import ru.kpfu.itis.mustafin.services.impl.CityServiceImpl;
import ru.kpfu.itis.mustafin.util.TrainingScheduleConstructor;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final CityService cityService;
    private final SportsClubService sportsClubService;
    private final SectionService sectionService;
    private final TeacherService teacherService;
    private final TrainingService trainingService;

    @Autowired
    public MainController(CityService cityServ, SportsClubService sportsClubServ,
                          SectionService sectionServ, TeacherService teacherServ, TrainingService trainingServ){
        this.cityService = cityServ;
        this.sportsClubService = sportsClubServ;
        this.sectionService = sectionServ;
        this.teacherService = teacherServ;
        this.trainingService = trainingServ;
    }

    @RequestMapping("/cities")
    public String cities(Model model){
        List<City> cities = cityService.getAll();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @RequestMapping("/sportsclubs")
    public String sportsClubs(Model model, @RequestParam("cityid") long cityId){
        List<SportsClub> sportsClubs = sportsClubService.getByCityId(cityId);
        model.addAttribute("sportsClubs", sportsClubs);
        return "sportsclubs";
    }

    @RequestMapping("/sections")
    public String sections(Model model, @RequestParam("sportsclubid") long sportsClubId){
        List<Section> sections = sectionService.getAll();
        model.addAttribute("sections", sections);
        model.addAttribute("sportsclubid", sportsClubId);
        return "sections";
    }

    @RequestMapping("/teachers")
    public String teachers(Model model, @RequestParam("sportsclubid") long sportsClubId, @RequestParam("sectionid") long sectionId){
        List<Teacher> teachers = teacherService.getBySportsClubAndSection(sportsClubId, sectionId);
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @RequestMapping("/schedule")
    public String schedule(Model model, @RequestParam("teacherid") long teacherId){
        List<Training> trainings = trainingService.getByTeacherSorted(teacherId);
        Map<String, List<String>> schedule = TrainingScheduleConstructor.construct(trainings);
        model.addAttribute("trainings", schedule);
        return "schedule";
    }

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
}
