package iti.xml;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class App {

    public static void main(String[] args) throws Exception {

        InputStream is = App.class
                .getClassLoader()
                .getResourceAsStream("person.json");

        JsonReader reader = Json.createReader(is);
        JsonObject person = reader.readObject();
        printJson(person);

        OutputStream os = new FileOutputStream("person-generated.json");
        JsonWriter writer = Json.createWriter(os);
        JsonObject generatedPerson = generateJson();
        writer.writeObject(generatedPerson);
        writer.close();
    }

    public static void printJson(JsonObject obj){

        System.out.println("name: " + obj.getString("name"));

        System.out.println("email: " + obj.getString("email"));

        System.out.println("age: " + obj.getInt("age"));

        JsonArray hobbies = obj.getJsonArray("hobbies");
        for (int i = 0; i < hobbies.size(); i++) {
            System.out.println(hobbies.getString(i));
        }
    }

    public static JsonObject generateJson(){
        return Json.createObjectBuilder()
                .add("name","Khaled Ali")
                .add("email","khaled@gmail.com")
                .add("age",50)
                .add("hobbies", Json.createArrayBuilder()
                        .add("Reading")
                        .add("shopping")
                )
                .build();
    }
}
