package ru.innopolis.nikn.models.services;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Nikolay on 28.11.2016.
 */
public interface ILecturesService {

    public ModelAndView getLectures();

    public String addLecturesAction(Map<String, String> requestParams);

}
