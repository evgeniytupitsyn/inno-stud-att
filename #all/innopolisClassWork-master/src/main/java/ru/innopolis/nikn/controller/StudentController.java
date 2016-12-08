package ru.innopolis.nikn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.nikn.models.services.IStudentService;

import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView getStudentList() {
        ModelAndView model = studentService.getStudents();
        model.addObject("title", "View Student list");
        return model;

    }

    @GetMapping(value = "/add-student")
    public ModelAndView addStudent() {
        ModelAndView model = new ModelAndView("add-student");
        model.addObject("title", "Add new Student");
        return model;

    }

    @PostMapping(value = "/add-student")
    public String addStudent(@RequestParam Map<String,String> requestParams) {
        return studentService.addStudentAction(requestParams);
    }

}
