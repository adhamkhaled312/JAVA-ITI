package iti.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;


public class App {


    public static void main(String[] args) throws Exception{
        File xmlFile = new File(App.class.getResource("/notes.xml").toURI());
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = documentFactory.newDocumentBuilder();
        Document document = parser.parse(xmlFile);

        TransformerFactory transformFactory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(App.class.getResource("/notes.xslt").toURI()));
        Transformer transformer = transformFactory.newTransformer(xslt);

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("notes.html"));
        
        transformer.transform(source,result);
        
    }

}