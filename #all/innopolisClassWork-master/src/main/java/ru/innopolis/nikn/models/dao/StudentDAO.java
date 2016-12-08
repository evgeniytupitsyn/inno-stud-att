package ru.innopolis.nikn.models.dao;


import ru.innopolis.nikn.models.entities.Student;

import java.util.List;

/**
 * Created by Nikolay on 22.11.2016.
 */
public interface StudentDAO {

    public boolean createStudent(Student student);
    public boolean updateStudent(Student student);
    public boolean deleteStudent(Student student);
    public List<Student> findAll();
    public Student findById(int id);

}
