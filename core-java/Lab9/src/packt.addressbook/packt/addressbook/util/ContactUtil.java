package packt.addressbook.util;

import packt.addressbook.model.Contact;

import java.util.ArrayList;
import java.util.List;
public class ContactUtil {

    public static List<Contact> getContacts() {

        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact(
                "1", "John", "Doe",
                "111-111", "222-222", "john@example.com"));

        contacts.add(new Contact(
                "2", "Alice", "Smith",
                "333-333", "444-444", "alice@example.com"));

        contacts.add(new Contact(
                "3", "Bob", "Brown",
                "555-555", "666-666", "bob@example.com"));

        return contacts;
    }
}
