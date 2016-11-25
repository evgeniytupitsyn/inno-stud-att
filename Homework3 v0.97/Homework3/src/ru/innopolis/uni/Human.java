package ru.innopolis.uni;

/**
 * Class that is to be serialized.
 *
 * Created by Влад on 08.11.2016.
 */
public class Human {

    private final int money = 1;
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Human() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;

        Human human = (Human) o;

        if (getAge() != human.getAge()) return false;
        return getName().equals(human.getName());

    }

    @Override
    public int hashCode() {
        int result = getAge();
        result = 31 * result + getName().hashCode();
        return result;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
