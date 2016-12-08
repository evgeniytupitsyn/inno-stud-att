package ru.innopolis.nikn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.nikn.models.services.IJournalService;

import java.util.Map;

/**
 * Created by Nikolay on 28.11.2016.
 */
@Controller
public class JournalController {
    @Autowired
    IJournalService journalService;

    @GetMapping(value = "/")
    public ModelAndView getData() {

        ModelAndView model = journalService.getJournals();

        return model;

    }

    @GetMapping(value = "/add-journal-row")
    public ModelAndView getAddJournalForm() {
        return journalService.getAddJournalForm();

    }

    @PostMapping(value = "/add-journal-row")
    public String addJournal(@RequestParam Map<String,String> requestParams) {
        return journalService.addJournalAction(requestParams);

    }
}
