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

        Dog dog = new Dog("Graf", 40) {
            @Override
            public void writeExternal(ObjectOutput out) throws IOException {

            }

            @Override
            public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

            }
        };
        //dog.setSkill(new Skill ("To bark", 100));
        try(FileOutputStream fileOutputStream = new FileOutputStream("./resource.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(dog);
            System.out.println(dog);
            objectOutputStream.flush();
        }
    }


}
