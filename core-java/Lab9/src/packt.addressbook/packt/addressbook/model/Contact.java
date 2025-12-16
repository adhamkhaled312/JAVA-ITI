package packt.addressbook.model;

public class Contact {

    private String id;
    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private String email;

    public Contact(String id, String firstName, String lastName,
                   String homePhone, String workPhone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
               " | Home: " + homePhone +
               " | Work: " + workPhone +
               " | Email: " + email;
    }
}
