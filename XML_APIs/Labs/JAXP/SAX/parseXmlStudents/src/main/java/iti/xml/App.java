package iti.xml;

import java.io.File;
import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class App {

    public static void main(String[] args) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();

        parser.parse(new File(App.class.getResource("/students.xml").toURI()), handler);
    }

 
}
