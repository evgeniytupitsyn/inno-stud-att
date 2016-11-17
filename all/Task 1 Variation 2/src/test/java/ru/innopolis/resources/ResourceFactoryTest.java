package ru.innopolis.resources;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class ResourceFactoryTest {

    private static Logger logger = LoggerFactory.getLogger("ru.innopolis.Test");

    @Test
    public void createResourceWithParam() throws Exception {

        Resource resource = ResourceFactory.createResourceWithParam("qwerty");
        assertTrue("Объект нужного класса не был создан", resource.getClass() == StringResource.class);

        Resource resource1 = ResourceFactory.createResourceWithParam("qwerty.txt");
        assertTrue("Объект нужного класса не был создан", resource1.getClass() == TxtFileResource.class);

        Resource resource2 = ResourceFactory.createResourceWithParam("C:\\RandomDir\\RandomSubDir\\RandomFile.txt");
        assertTrue("Объект нужного класса не был создан", resource2.getClass() == TxtFileResource.class);



        Resource resource3 = ResourceFactory.createResourceWithParam("C:\\RandomDir\\RandomSubDir\\RandomFile.doc");
        assertFalse("Объект этого класса не должен был создаться", resource3.getClass() == TxtFileResource.class);

    }

}
