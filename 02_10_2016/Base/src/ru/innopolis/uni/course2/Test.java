package ru.innopolis.uni.course2;

import ensty.*;
import ru.innopolis.uni.course2.autoclosabletest.MyResource;

import java.io.*;
import java.util.*;

import static java.lang.System.*;

/**
 * Created by evgeniytupitsyn on 01/11/2016.
 */
public class Test <T extends Animal, Serializable> {

    public static void main(String[] args) throws IOException {

        Dog dog = new Dog("Graf", 40);
        //dog.setSkill(new Skill ("To bark", 100));
        try(FileOutputStream fileOutputStream = new FileOutputStream("./resource.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(dog);
            System.out.println(dog);
            objectOutputStream.flush();
        }
        /*try (MyResource myResource = new MyResource();
             MyResource myResource1 = null;
             MyResource myResource2 = new MyResource()){
            throw new RuntimeException();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            System.out.println("finally!");
            throw new RuntimeException("Some");
        }*/
    }

    /*public static void main(String[] args) throws IOException {
        //OutputStream outputStream = null;
        try(OutputStream outputStream = new FileOutputStream("./resource.txt");
            //outputStream = new FileOutputStream("./resource.txt");
            OutputStream outputStream2 = null){
            outputStream.write(5);
            outputStream.flush();
            System.out.println(outputStream2);
        }catch (IOException e){

        }finally {
            *//*if (outputStream!=null){
                try{
                    outputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }*//*
        }


        InputStream inputStream = new FileInputStream("./resource.txt");
        int i = inputStream.read();
        System.out.println(i);
        inputStream.close();

    }*/

  /*  int a;
    {
        a = 5;
    }*/

   /* public static void main(String[] args) throws IOException{
        Main main = new Main();
        System.out.println(main.doSome(5));

    }*/


/*        for (int i = 1; i<100; i++){
            if ((i % 2) == 0){
                continue;          //если return, то мб закончиться выполнение void
            }
            sum += i;
        }*/

        //вложенные циклы
/*        LoopLabel:
        for (int j = 1; j<100; j++){
            for (int i = 1; i<100; i++){
                if (i == 5) {
                    break LoopLabel;          //если return, то мб закончиться выполнение void
                }
                sum += i;
            }
        }*/

        //switch
/*        int sum = 3;

        switch (sum) {
            case 0: {
                System.out.print("case 0");
                break;
            }
            case 1: {
                System.out.print("case 1");
                break;
            }
            case 2: {
                System.out.print("case 2");
                break;
            }
            case 3: {
                System.out.print("case 3");
                break;
            }
            case 4: {
                System.out.print("case 4");
                break;
            }
            default:{
                System.out.print("case default");
                break;
            }
        }


        System.out.print(sum);
    }*/
/*


    public static void feedPets(Collection<? extends Animal> pets){
        for (Animal animal: pets){
            animal.feed();
        }
    }
*/



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
