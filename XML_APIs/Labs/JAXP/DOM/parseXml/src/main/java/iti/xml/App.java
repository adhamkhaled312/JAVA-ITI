package iti.xml;

import java.io.File;
import java.lang.annotation.ElementType;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class App {


    public static void main(String[] args) throws Exception{
        File xmlFile = new File(App.class.getResource("/notes.xml").toURI());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document document = parser.parse(xmlFile);

        Element root = document.getDocumentElement();
        App app = new App();
        app.traverse(root);
    }

    private void traverse(Node node){
        String type = getNodeType(node.getNodeType());
        System.out.println("Node: "+node.getNodeName()+", Type: "+type+", value: "+node.getNodeValue());

        NamedNodeMap map = node.getAttributes();

        if(map!=null){
            for(int i=0; i<map.getLength();i++){
                Node attribute = map.item(i);
                System.out.println(" Attribute: "+attribute.getNodeName()+", Value: "+attribute.getNodeValue());
            }
        }

        NodeList children = node.getChildNodes();
        for(int i=0; i<children.getLength(); i++){
            traverse(children.item(i));
        }
    } 

    private String getNodeType(short nodeType){
        switch (nodeType) {
            case Node.ELEMENT_NODE:
                return "Element";

            case Node.ATTRIBUTE_NODE:
                return "Attribute";

            case Node.TEXT_NODE:
                return "Text";

            case Node.CDATA_SECTION_NODE:
                return "CDATA";

            case Node.ENTITY_REFERENCE_NODE:
                return "Entity_Reference";

            case Node.ENTITY_NODE:
                return "Entity";

            case Node.PROCESSING_INSTRUCTION_NODE:
                return "Processing_Instruction";

            case Node.DOCUMENT_NODE:
                return "Document";

            case Node.DOCUMENT_TYPE_NODE:
                return "Document_Type";

            case Node.DOCUMENT_FRAGMENT_NODE:
                return "Document_Fragment";

            case Node.NOTATION_NODE:
                return "Notation";

            case Node.COMMENT_NODE:
                return "Comment";
            default:
                return "Undefined";
        }
    }
}