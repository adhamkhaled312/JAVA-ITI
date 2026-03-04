package iti.xml;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class App {

    public static void main(String[] args) throws Exception {

        InputStream is = App.class
                .getClassLoader()
                .getResourceAsStream("person.json");

        JsonParser parser = Json.createParser(is);
        printJson(parser);

        OutputStream os = new FileOutputStream("person-generated.json");
        JsonGenerator generator = Json.createGenerator(os);
        generateJson(generator);
    }

    public static void printJson(JsonParser parser) {
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();

            switch (event) {
                case START_OBJECT:
                    System.out.println("START_OBJECT");
                    break;
                case END_OBJECT:
                    System.out.println("END_OBJECT");
                    break;
                case START_ARRAY:
                    System.out.println("START_ARRAY");
                    break;
                case END_ARRAY:
                    System.out.println("END_ARRAY");
                    break;
                case KEY_NAME:
                    System.out.println("KEY_NAME: " + parser.getString());
                    break;
                case VALUE_STRING:
                    System.out.println("VALUE_STRING: " + parser.getString());
                    break;
                case VALUE_NUMBER:
                    System.out.println("VALUE_NUMBER: " + parser.getInt());
                    break;
                case VALUE_TRUE:
                    System.out.println("VALUE_TRUE");
                    break;
                case VALUE_FALSE:
                    System.out.println("VALUE_FALSE");
                    break;
                case VALUE_NULL:
                    System.out.println("VALUE_NULL");
                    break;
                default:
                    System.out.println("UNKNOWN_EVENT");
                    break;
            }
        }
    }

    public static void generateJson(JsonGenerator generator) {
        generator.writeStartObject()
                .write("name", "Khaled Ali")
                .write("email", "khaled@gmail.com")
                .write("age", 50)
                .writeStartArray("hobbies")
                .write("Reading")
                .write("shopping")
                .writeEnd()
                .writeEnd();
        generator.flush();
    }
}
