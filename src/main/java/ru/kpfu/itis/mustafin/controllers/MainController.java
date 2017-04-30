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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @RequestMapping("/")
    void start(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login");
    }

    @RequestMapping("/catalog/cities")
    public String cities(Model model){
        List<City> cities = cityService.getAll();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @RequestMapping("/catalog/sportsclubs")
    public String sportsClubs(Model model, @RequestParam("cityid") long cityId){
        List<SportsClub> sportsClubs = sportsClubService.getByCityId(cityId);
        List<City> cities = cityService.getAll();
        model.addAttribute("cityid", cityId);
        model.addAttribute("cities", cities);
        model.addAttribute("sportsClubs", sportsClubs);
        return "sportsclubs";
    }

    @RequestMapping("/catalog/sections")
    public String sections(Model model, @RequestParam("sportsclubid") long sportsClubId){
        List<Section> sections = sectionService.getAll();
        model.addAttribute("sections", sections);
        model.addAttribute("sportsclubid", sportsClubId);
        return "sections";
    }

    @RequestMapping("/catalog/teachers")
    public String teachers(Model model, @RequestParam("sportsclubid") long sportsClubId, @RequestParam("sectionid") long sectionId){
        List<Teacher> teachers = teacherService.getBySportsClubAndSection(sportsClubId, sectionId);
        model.addAttribute("sportsclubid", sportsClubId);
        model.addAttribute("sectionid", sectionId);
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @RequestMapping("/catalog/schedule")
    public String schedule(Model model, @RequestParam("teacherid") long teacherId){
        Teacher teacher = teacherService.getById(teacherId);
        List<Training> trainings = trainingService.getByTeacherSorted(teacherId);
        Map<String, List<Long>> schedule = TrainingScheduleConstructor.construct(trainings);
        model.addAttribute("teacher", teacher);
        model.addAttribute("trainings", schedule);
        return "schedule";
    }

    @RequestMapping("/catalog/")
    public String index(Model model){
        return "start";
    }
}
