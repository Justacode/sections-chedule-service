package ru.kpfu.itis.mustafin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.mustafin.models.*;
import ru.kpfu.itis.mustafin.services.*;

@Controller
public class AdminController {

    private final CityService cityService;
    private final SportsClubService sportsClubService;
    private final SectionService sectionService;
    private final TeacherService teacherService;
    private final TrainingService trainingService;

    @Autowired
    public AdminController(CityService cityServ, SportsClubService sportsClubServ,
                           SectionService sectionServ, TeacherService teacherServ, TrainingService trainingServ) {
        this.cityService = cityServ;
        this.sportsClubService = sportsClubServ;
        this.sectionService = sectionServ;
        this.teacherService = teacherServ;
        this.trainingService = trainingServ;
    }

    @RequestMapping(value = "/admin/catalog/cities/new", method = RequestMethod.POST)
    public String addNewCity(@RequestParam("newcityname") String name) {
        if (!name.equals("")) {
            if (cityService.getByName(name) == null) {
                City newCity = new City(name);
                cityService.addCity(newCity);
            }
        }
        return "redirect:/catalog/cities";
    }

    @RequestMapping(value = "/admin/catalog/cities/delete")
    public String deleteCity(@RequestParam("deletingcityid") Long id) {
        cityService.delete(id);
        return "redirect:/catalog/cities";
    }

    @RequestMapping(value = "/admin/catalog/sportsclubs/new", method = RequestMethod.POST)
    public String addNewSportsClub(@RequestParam("newsportsclubname") String name,
                                   @RequestParam("cityid") Long id) {
        if (!name.equals("")) {
            SportsClub newSportsClub = new SportsClub();
            City referensed = cityService.getById(id);
            newSportsClub.setName(name);
            newSportsClub.setCity(referensed);
            sportsClubService.addSportsClub(newSportsClub);
        }
        return "redirect:/catalog/sportsclubs?cityid=" + id;
    }

    @RequestMapping(value = "/admin/catalog/sportsclubs/delete")
    public String deleteSportsClub(@RequestParam("deletingsportsclubid") Long id,
                                   @RequestParam("cid") Long cityId) {
        sportsClubService.delete(id);
        return "redirect:/catalog/sportsclubs?cityid=" + cityId;
    }

    @RequestMapping(value = "/admin/catalog/sections/new", method = RequestMethod.POST)
    public String addNewSection(@RequestParam("newsectionname") String name
            , @RequestParam("sportsclubid") Long sportsClubId) {
        if (!name.equals("")) {
            if (cityService.getByName(name) == null) {
                Section newSection = new Section();
                newSection.setName(name);
                sectionService.addSection(newSection);
            }
        }
        return "redirect:/catalog/sections?sportsclubid=" + sportsClubId;
    }

    @RequestMapping(value = "/admin/catalog/sections/delete")
    public String deleteSection(@RequestParam("deletingsectionid") Long sectionId,
                                @RequestParam("scid") Long scid) {
        sectionService.delete(sectionId);
        return "redirect:/catalog/sections?sportsclubid=" + scid;
    }

    @RequestMapping(value = "/admin/catalog/teachers/new", method = RequestMethod.POST)
    public String addNewTeacher(@RequestParam("newteachername") String name,
                                @RequestParam("age") int age, @RequestParam("phone") String phone,
                                @RequestParam("regalia") String regalia, @RequestParam("experience") int exp,
                                @RequestParam("sportsclubid") Long sportsClubId, @RequestParam("sectionid") Long sectionId) {
        if (!name.equals("")) {
            Section refSec = sectionService.getById(sectionId);
            SportsClub refSport = sportsClubService.getById(sportsClubId);
            Teacher newTeacher = new Teacher();
            newTeacher.setFullName(name);
            newTeacher.setAge(age);
            newTeacher.setPhoneNumber(phone);
            newTeacher.setRegalia(regalia);
            newTeacher.setWorkExperience(exp);
            newTeacher.setSection(refSec);
            newTeacher.setSportsClub(refSport);
            teacherService.addTeacher(newTeacher);
        }
        return "redirect:/catalog/teachers?sportsclubid=" + sportsClubId + "&sectionid=" + sectionId;
    }

    @RequestMapping(value = "/admin/catalog/teachers/delete")
    public String deleteTeacher(@RequestParam("deletingteacherid") Long teacherId,
                                @RequestParam("scid") Long scid, @RequestParam("sid") Long sid) {
        teacherService.delete(teacherId);
        return "redirect:/catalog/teachers?sportsclubid=" + scid + "&sectionid=" + sid;
    }

    @RequestMapping(value = "/admin/catalog/trainings/new", method = RequestMethod.POST)
    public String addTraining(@RequestParam("day") int day, @RequestParam("time") String time,
                              @RequestParam("teacherid") Long teacherId) {
        if (trainingService.getByTeacherAndDayAndTime(teacherId, day, time) == null) {
            Teacher refTeach = teacherService.getById(teacherId);
            Training newTraining = new Training();
            newTraining.setDay(day);
            newTraining.setTime(time);
            newTraining.setTeacher(refTeach);
            trainingService.addTraining(newTraining);
        }
        return "redirect:/catalog/schedule?teacherid=" + teacherId;
    }
    @RequestMapping(value = "/admin/catalog/trainings/delete")
    public String deleteTraining(@RequestParam("trainingid") Long trainingId,
                                 @RequestParam("teacherid") Long teacherId){
        trainingService.delete(trainingId);
        return "redirect:/catalog/schedule?teacherid=" + teacherId;
    }
}
