package ru.innopolis.nikn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.nikn.models.services.ILecturesService;

import java.util.Map;

@Controller
public class LectureController {

    @Autowired
    ILecturesService lecturesService;

    @RequestMapping(value = "/lectures", method = RequestMethod.GET)
    public ModelAndView getStudentList() {
        ModelAndView model = lecturesService.getLectures();
        return model;
    }

    @GetMapping(value = "/add-lecture")
    public ModelAndView addStudent() {
        ModelAndView model = new ModelAndView("add-lecture");
        model.addObject("title", "Add new Lecture");
        return model;

    }

    @PostMapping(value = "/add-lecture")
    public String addStudent(@RequestParam Map<String,String> requestParams) {
        return lecturesService.addLecturesAction(requestParams);
    }
}
