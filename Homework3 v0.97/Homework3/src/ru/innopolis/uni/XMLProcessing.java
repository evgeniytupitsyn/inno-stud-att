package ru.innopolis.uni;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Влад on 08.11.2016.
 */
public class XMLProcessing extends DefaultHandler {

    /**
     * Deserializing an object to a POJO instance.
     *
     * @param fileName
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public Object deserializeFromXML(String fileName)
            throws ParserConfigurationException, IOException, SAXException,
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(fileName));
        doc.getDocumentElement().normalize();

        String value1 = null;
        int value2 = 0;

        NodeList nodeList = doc.getElementsByTagName("property");
        for (int i=0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element)nodeList.item(i);
                if (element.getAttribute("name").equals("name")) {
                    value1 = element.getTextContent();
                }
                if (element.getAttribute("name").equals("age")) {
                    value2 = Integer.parseInt(element.getTextContent());
                }
            }
        }

        Class clazz = Class.forName(doc.getDocumentElement().getNodeName().toString());
        System.out.println(doc.getDocumentElement().getNodeName().toString());
        Constructor[] constructors = clazz.getDeclaredConstructors();
        return constructors[0].newInstance(
                new Object[] {value2, value1});
    }

    /**
     * Serializing an object to an XML file, using DOM parser.
     *
     * @param serializedObject - An object to be serialized.
     * @param fileName - which file you want to serialize an object.
     * @throws IllegalAccessException
     */
    public void serializeToXML(Object serializedObject, String fileName) throws
            IllegalAccessException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;

        // Getting a fields of an object to be serialized further.
        Field[] fields = serializedObject.getClass().getDeclaredFields();
        // Making a field accessible in a Reflection mechanism.
        for(Field field:fields) {
            field.setAccessible(true);
        }

        try {
            docBuilder = docFactory.newDocumentBuilder();
            // Adding a root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement(
                    serializedObject.getClass().getCanonicalName());
            doc.appendChild(rootElement);
            Element childElement1;

            for (int i = 0; i < fields.length; i++) {
                // Creating an element for name field.
                childElement1 = doc.createElement("property");
                childElement1.setAttribute("name", fields[i].getName());
                childElement1.setAttribute("type", fields[i].getType().getName());
                childElement1.appendChild(doc.createTextNode(
                        fields[i].get(serializedObject).toString()));
                rootElement.appendChild(childElement1);
//                childElement1 = doc.createElement(fields[i].getName());
//                childElement1.setAttribute("type", fields[i].getType().toString());
//                childElement1.setAttribute("value", fields[i].get(serializedObject).toString());
//                rootElement.appendChild(childElement1);
            }

            //** Write the content into XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //** Injecting an indentation to an XML file saving
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");

            DOMConfiguration docConfig = doc.getDomConfig();
            docConfig.setParameter("infoset", Boolean.TRUE);
            doc.normalizeDocument();
            DOMSource source = new DOMSource(doc);
            // Print to a file
            StreamResult result = new StreamResult(new File(fileName));
            // Print to sout
//            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
            System.out.println("Object with class \"" + serializedObject.getClass()
                    + "\" has been serialized to an XML file \"" + fileName + "\".");
        } catch (ParserConfigurationException ex) {
//            Logger.getLogger(XMLManagement.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Some trouble");
        } catch (TransformerConfigurationException ex) {
//            Logger.getLogger(XMLManagement.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Some trouble");
        } catch (TransformerException ex) {
//            Logger.getLogger(XMLManagement.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Some trouble");
        }

    }

}
