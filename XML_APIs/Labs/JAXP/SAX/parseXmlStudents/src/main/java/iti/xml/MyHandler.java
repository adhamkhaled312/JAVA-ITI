package iti.xml;

import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

class MyHandler extends DefaultHandler{
    private ArrayList<Student> list;
    private Student currentStudent;
    private String currentElement;
    private String currentText;
    
    @Override
    public void startDocument(){
        list = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        currentElement = qName;
        if(qName.equals("student")){
            currentStudent = new Student();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if(length==0) return;
        currentText = new String(ch, start, length).trim();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(qName.equals("students")) return;
        if(qName.equals("student")){
            list.add(currentStudent);
            return;
        }

        switch (currentElement) {
            case "name":
                currentStudent.setName(currentText);
                break;
            case "age":
                currentStudent.setAge(Integer.parseInt(currentText));
                break;
            case "email":
                currentStudent.setEmail(currentText);
                break;
            case "phone":
                currentStudent.setPhone(currentText);
                break;
            case "track":
                currentStudent.setTrack(currentText);
                break;
            case "about":
                currentStudent.setAbout(currentText);
                break;
            default:
                return;
        }
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("Error: " + e.getMessage());
        throw e;
    }
    @Override
    public void endDocument (){
        for(Student s: list){
            System.out.println(s);
        }
   }
}