package ru.innopolis.nikn.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.nikn.models.dao.LectureDAO;
import ru.innopolis.nikn.models.dao.StudentDAO;
import ru.innopolis.nikn.models.entities.Lecture;
import ru.innopolis.nikn.models.entities.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 28.11.2016.
 */
@Component
public class LecturesServiceImpl implements ILecturesService {

    @Autowired
    LectureDAO lectureDAO;

    @Override
    public ModelAndView getLectures() {
        List<Lecture> lectures = lectureDAO.findAll();
        ModelAndView modelAndView = new ModelAndView("lectures");
        modelAndView.addObject("lectures", lectures);
        return modelAndView;
    }

    @Override
    public String addLecturesAction(Map<String, String> requestParams) {
        Lecture lecture = new Lecture();
        lecture.setName(requestParams.get("name"));
        if(lectureDAO.createLecture(lecture)) {
            return "redirect:/lectures";
        }
        return "/add-lecture";
    }
}
