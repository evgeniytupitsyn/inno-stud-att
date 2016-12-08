package ru.innopolis.nikn.models.services;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Nikolay on 28.11.2016.
 */
public interface IJournalService {

    public String addJournalAction(Map<String,String> requestParams);

    public ModelAndView getJournals();

    public ModelAndView getAddJournalForm();
}
