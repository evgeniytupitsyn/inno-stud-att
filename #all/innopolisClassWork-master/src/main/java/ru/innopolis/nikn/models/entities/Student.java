package ru.innopolis.nikn.models.entities;

/**
 * Created by Nikolay on 25.11.2016.
 */

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int group;
    private int sexId;
    private int countLecture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    public int getCountLecture() {
        return countLecture;
    }

    public void setCountLecture(int countLecture) {
        this.countLecture = countLecture;
    }
}
