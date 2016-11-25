package ru.innopolis.uni;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Serialize an object with class Human and deserialize it back.
 * In the end there is a comparison showing if an objects do match, i.e.
 * if a process is successful.
 *
 * Created by Влад on 08.11.2016.
 */
public class Main {

    XMLProcessing xMLProcessing = new XMLProcessing();

    public static void main(String[] args) throws IllegalAccessException,
            ParserConfigurationException, SAXException, IOException,
            ClassNotFoundException, NoSuchMethodException, InstantiationException,
            InvocationTargetException {
        Main main = new Main();
        Human human = new Human(33, "Влад");
        Human human2;
        // Serializing an object human to a file human.xml.
        // Check a presence of a file human.xml in a root folder of a project.
        main.xMLProcessing.serializeToXML(human, "human.xml");
        // Deserializing an object human back to a memory.
        human2 = (Human)main.xMLProcessing.deserializeFromXML("human.xml");
        // Checking if a deserialized Human equals to a new Human(33, "Влад");
        System.out.println(human.equals(human2)); // true
    }

}
