package iti.xml;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class App {

    public static void main(String[] args) throws Exception {

        JAXBContext context = JAXBContext.newInstance("iti.xml");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        File xmlFile = new File("src/main/resources/person.xml");

        JAXBElement<PersonType> element =
                (JAXBElement<PersonType>) unmarshaller.unmarshal(xmlFile);

        PersonType person = element.getValue();

        printPerson(person);

        person.setName("Khaled Ali");

        AddressType address = person.getAddress();
        address.setNumber(90);
        address.setStreet("Abbas Akkad");

        printPerson(person);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


        ObjectFactory factory = new ObjectFactory();
        JAXBElement<PersonType> outputElement = factory.createPerson(person);

        File outputFile = new File("src/main/resources/person-updated.xml");
        marshaller.marshal(outputElement, outputFile);
    }

    private static void printPerson(PersonType person) {
        System.out.println("Name    : " + person.getName());
        System.out.println("Address : " + person.getAddress().getNumber()
                           + " " + person.getAddress().getStreet());
    }
}