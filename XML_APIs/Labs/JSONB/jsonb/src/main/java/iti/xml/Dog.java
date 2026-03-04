package iti.xml;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.config.PropertyOrderStrategy;

@JsonbPropertyOrder({"biteable", "age", "dogName"})
public class Dog {
    @JsonbProperty("dogName")
    public String name;
    public int age;
    public boolean biteable;
    public Dog(){}

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", biteable=" + biteable +
                '}';
    }
}
