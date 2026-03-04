package iti.xml;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    private String name;
    private String email;

    @XmlTransient
    private int age;
    private Address address;

    @XmlElementWrapper(name = "hobbies")
    @XmlElement(name = "hobby")
    private List<String> hobbies = new ArrayList<>();

    public Person() {
    }

    public Person(String name, String email, int age, Address address, List<String> hobbies) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress(){
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }
}
