package iti.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class App {
    public static Person unmarshal(String xmlFilePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Person) unmarshaller.unmarshal(new File(xmlFilePath));
    }

    public static void marshal(Person person, String outputFilePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(person, new File(outputFilePath));
    }

    public static void main(String[] args) {
        String inputFile = "src/main/resources/person.xml";
        String outputFile = "src/main/resources/person_updated.xml";

        try {
            Person person = unmarshal(inputFile);

            System.out.println(person);

            person.setName("Khaled Ali");      
            person.setEmail("khaled@gmail.com");      
            person.getAddress().setStreet("Abbas El Akkad");
            System.out.println(person);

            marshal(person, outputFile);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}