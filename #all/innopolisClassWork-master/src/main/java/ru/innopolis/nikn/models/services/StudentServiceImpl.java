package ru.innopolis.nikn.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.nikn.models.dao.StudentDAO;
import ru.innopolis.nikn.models.entities.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 28.11.2016.
 */
@Component
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentDAO studentDAO;

    @Override
    public ModelAndView getStudents() {
        List<Student> students = studentDAO.findAll();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @Override
    public String addStudentAction(Map<String,String> requestParams) {
        Student student = new Student();
        student.setFirstName(requestParams.get("first-name"));
        student.setLastName(requestParams.get("last-name"));
        student.setGroup(Integer.parseInt(requestParams.get("group")));
        if(studentDAO.createStudent(student)) {
            return "redirect:/students";
        }
        return "/add-student";
    }
}
