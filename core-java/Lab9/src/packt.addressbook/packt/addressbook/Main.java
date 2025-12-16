package packt.addressbook;

import packt.addressbook.model.Contact;
import packt.addressbook.util.ContactUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Contact> contacts = ContactUtil.getContacts();

        System.out.println("=== Address Book ===");
        contacts.forEach(System.out::println);
    }
}
