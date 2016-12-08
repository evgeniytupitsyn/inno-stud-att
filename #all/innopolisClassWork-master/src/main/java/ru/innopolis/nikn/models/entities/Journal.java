package ru.innopolis.nikn.models.entities;


import java.sql.Date;

/**
 * Created by Nikolay on 28.11.2016.
 */
public class Journal {

    private int id;
    private Student student;
    private Lecture lecture;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
