package ru.innopolis.nikn.models.dao;


import ru.innopolis.nikn.models.entities.Lecture;

import java.util.List;

/**
 * Created by Nikolay on 22.11.2016.
 */
public interface LectureDAO {

    public boolean createLecture(Lecture lecture);
    public boolean updateLecture(Lecture lecture);
    public boolean deleteLecture(Lecture lecture);
    public List<Lecture> findAll();
    public  Lecture findById(int id);

}
