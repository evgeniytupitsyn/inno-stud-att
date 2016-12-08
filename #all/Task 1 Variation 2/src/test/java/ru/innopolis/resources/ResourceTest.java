package ru.innopolis.resources;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.*;

public class ResourceTest {

    private static Logger logger = LoggerFactory.getLogger("ru.innopolis.Test");

    @Test
    public void getInputParam() throws Exception {

        Resource resource = ResourceFactory.createResourceWithParam("абв");
        assertEquals("Входной параметр неверен", "абв", resource.getInputParam());

        Resource resource1 = ResourceFactory.createResourceWithParam("C:\\Windows\\Help\\Help\\ru-RU\\Help.h1c");
        assertEquals("Входной параметр неверен", "C:\\Windows\\Help\\Help\\ru-RU\\Help.h1c", resource1.getInputParam());

        Resource resource2 = ResourceFactory.createResourceWithParam("qwerty123!@#$%^&*()");
        assertEquals("Входной параметр неверен", "qwerty123!@#$%^&*()", resource2.getInputParam());

    }

    @Test
    public void initText() {

        Resource resource = ResourceFactory.createResourceWithParam("абв");

        try {
            resource.initText();
        } catch (IOException e) {
            logger.error("IOException" , e);
        }

        assertEquals("Текст неверный", "абв", resource.getText());

    }

    @Test
    public void isTextCorrect() throws Exception {
        Resource resource = ResourceFactory.createResourceWithParam("абв?.,!123 йцукен    шшнг");

        try {
            resource.initText();
        } catch (IOException e) {
            logger.error("IOException" , e);
        }

        assertTrue("Текст должен быть верным",resource.isTextCorrect());

        Resource resource1 = ResourceFactory.createResourceWithParam("qwe?.,!123 йцукен    шшнг");

        try {
            resource1.initText();
        } catch (IOException e) {
            logger.error("IOException" , e);
        }

        assertFalse("Текст должен быть неверным",resource1.isTextCorrect());
    }

}