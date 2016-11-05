package ru.innopolis.uni.course2;

import ensty.*;

import java.util.*;

import static java.lang.System.*;

/**
 * Created by evgeniytupitsyn on 01/11/2016.
 */
public class Test {
    public Test() {
        super();
    }

    public static void main(String[] args) {
     //   List<String> list = new ArrayList<String>();
       // list.add(1);
     //   list.add("Hi!");
       // System.out.println((int)list.get(1));

        List<Cat> src = getCollection();
        List<Pet> dest = new ArrayList<>();
        {
            //cats.add(New Dog( vc))
            Collections.copy(dest,src);
            
            for (Pet pet:dest){
                pet.call();
            }
        }
    }

    private static List<Cat> getCollection() {
    }

    public static void feedPets(Collection<? extends Animal> pets){
        for (Animal animal: pets){
            animal.feed();
        }
    }



/*
    //Неприятная ситуация в результате отсутствия ковариантности.

    public static void printCollection(Collection<? extends> arg){     // ? - тип неизвестен, можно любой
        arg.add(1);             //Мы не понимаем, с каким типом мы работаем.
        for (Object o:arg){
            System.out.println(o);
        }
    }
*/
        /*//start Лекция 01_11_2016_Коллекции.
        //System.out.println("Test");
       // Main main = new Main();
      //  System.out.println("value = " + main.doSome(5));
       //list
       List students = generateStudents();

        //Map skillMap = new HashMap();

        for (Object student:students){
            Student s = (Student) student;
            System.out.println((s.getFirstName()));
        }

        //map
        Map skillMap = new HashMap();
        for (Object student:students){
            Student student1 = (Student) student;
            skillMap.put(student1, new Skill("java", (int) (Math.random() * 10)));
        }


        Student sourceJohn = (Student) students.get(0);
        sourceJohn.setLastName("NewLastName");  // если не пересчитать хэш, то выдаст null.
                                                // т. к. уже лежит в "другой корзине" -> inmutable объект нужен
        Student john = getJohn();

        //john.setLastName("NewReplaceLastName");

        Skill johnSkill = (Skill) skillMap.get(john);

        System.out.println(johnSkill);
        System.out.println("ok");
    }

    private static List<Student> generateStudents() {
        return Arrays.asList(new Student[]{
                new Student("John", "Connor"),
                new Student("John", "Connor2"),
                new Student("John", "Connor3"),
        });
    }

    public static Student getJohn() {
        return new Student ("John", "Connor");
    }

    */ //end Лекция 01_11_2016_Коллекции.
}
