package ru.innopolis.nikn.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.nikn.models.dao.JournalDAO;
import ru.innopolis.nikn.models.dao.LectureDAO;
import ru.innopolis.nikn.models.dao.StudentDAO;
import ru.innopolis.nikn.models.entities.Journal;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 28.11.2016.
 */
@Component
public class JournalService implements IJournalService{
    @Autowired
    JournalDAO journalDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    LectureDAO lectureDAO;

    @Override
    public String addJournalAction(Map<String, String> requestParams) {
        Journal journal = new Journal();
        int studentId = Integer.parseInt(requestParams.get("student_id"));
        journal.setStudent(studentDAO.findById(studentId));
        int lectureId = Integer.parseInt(requestParams.get("lecture_id"));
        journal.setLecture(lectureDAO.findById(lectureId));
        journal.setDate(Date.valueOf(requestParams.get("date")));

        if(journalDAO.createJournalRow(journal)) {
            return "redirect:/";
        }
        return "/add-journal-row";
    }

    @Override
    public ModelAndView getJournals() {
        List<Journal> journal = journalDAO.findAll();
        ModelAndView modelAndView = new ModelAndView("journal");
        modelAndView.addObject("journal", journal);
        return modelAndView;
    }

    @Override
    public ModelAndView getAddJournalForm() {
        ModelAndView modelAndView = new ModelAndView("add-journal");
        modelAndView.addObject("students", studentDAO.findAll());
        modelAndView.addObject("lectures", lectureDAO.findAll());
        return modelAndView;
    }

}
