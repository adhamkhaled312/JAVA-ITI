package iti.xml;

import java.io.File;
import javax.xml.parsers.SAXParser;
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

        parser.parse(new File(App.class.getResource("/books.xml").toURI()), handler);
    }

 
}
class MyHandler extends DefaultHandler{
    @Override
    public void startDocument(){
        System.out.println("Start document executed");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (length == 0) return;

        System.out.println("Characters Start: " + start + ", Length: " + length + ", End: " + (start + length - 1));
        System.out.println("Characters Contents: " + new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("Error: " + e.getMessage());
        throw e;
    }
}

