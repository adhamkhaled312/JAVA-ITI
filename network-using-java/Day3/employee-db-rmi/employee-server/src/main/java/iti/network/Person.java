package iti.network;

import java.io.Serializable;

public class Person implements Serializable {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    public Person() {}

    public Person(int id, String firstName, String middleName,
                  String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return id + " | " + firstName + " " + middleName + " " + lastName +
               " | " + email + " | " + phone;
    }
}
