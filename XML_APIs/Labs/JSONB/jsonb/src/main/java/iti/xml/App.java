package iti.xml;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        // Create a dog instance
        Dog dog1 = new Dog();
        dog1.name = "Falco";
        dog1.age = 4;
        dog1.biteable = false;
        Dog dog2 = new Dog();
        dog2.name = "cassidy";
        dog2.age = 8;
        dog2.biteable = true;

        Jsonb jsonb = JsonbBuilder.create();
        String firstResult = jsonb.toJson(dog1);
        System.out.println(firstResult);

        Dog fromJsonDog = jsonb.fromJson(firstResult, Dog.class);
        System.out.println(fromJsonDog);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        String secondResult = jsonb.toJson(dogs);
        System.out.println(secondResult);
        dogs = jsonb.fromJson(secondResult, new ArrayList<Dog>() {}.getClass().getGenericSuperclass());
        System.out.println(dogs.get(0));
    }
}
