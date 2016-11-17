package com.example.resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class FarmResourceTest {

    private static Logger logger = LoggerFactory.getLogger("com.example.Test");

    @Test
    public void createResourceWithParam() throws Exception {

        Resource resource = FarmResource.createResourceWithParam("ythtrsef");
        assertTrue("Объект нужного класса не был создан", resource.getClass() == StringResource.class);

        Resource resource1 = FarmResource.createResourceWithParam("ythtrsef.txt");
        assertTrue("Объект нужного класса не был создан", resource1.getClass() == TxtFileResource.class);

        Resource resource2 = FarmResource.createResourceWithParam("~\\RandomDir\\RandomSubDir\\RandomFile.txt");
        assertTrue("Объект нужного класса не был создан", resource2.getClass() == TxtFileResource.class);

        Resource resource3 = FarmResource.createResourceWithParam("~\\RandomDir\\RandomSubDir\\RandomFile.pdf");
        assertFalse("Объект этого класса не должен был создаться", resource3.getClass() == TxtFileResource.class);

    }

}
