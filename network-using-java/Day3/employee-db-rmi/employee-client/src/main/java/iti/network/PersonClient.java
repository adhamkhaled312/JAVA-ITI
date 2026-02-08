package iti.network;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class PersonClient {

    public static void main(String[] args) {

        try {
            Registry registry =
                    LocateRegistry.getRegistry("127.0.0.1", 1099);

            PersonService service =
                    (PersonService) registry.lookup("PersonService");

            Person p1 = new Person(1, "Ahmed", "Ali", "Hassan",
                    "ahmed@mail.com", "0100000001");

            Person p2 = new Person(2, "Mona", "Ibrahim", "Sayed",
                    "mona@mail.com", "0100000002");

            Person p3 = new Person(3, "Youssef", "Mahmoud", "Kamal",
                    "youssef@mail.com", "0100000003");

            service.addPerson(p1);
            service.addPerson(p2);
            service.addPerson(p3);

            Person selected = service.getPerson(2);
            System.out.println(selected);

            service.deletePerson(1);

            p3.setEmail("youssef.new@mail.com");
            p3.setPhone("0111111111");
            service.updatePerson(p3);

            List<Person> persons = service.getAllPersons();
            persons.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
