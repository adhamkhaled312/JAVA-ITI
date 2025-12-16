package addressbook.view;

import packt.addressbook.model.Contact;

import java.util.List;

public class TestModule{

    public static void main(String[] args) {

        Contact c1 = new Contact(
                "10", "Test", "User",
                "000-000", "999-999", "test@example.com");

        System.out.println(c1);
    }
}
