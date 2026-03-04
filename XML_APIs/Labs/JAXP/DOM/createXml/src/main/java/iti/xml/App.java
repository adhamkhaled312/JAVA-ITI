package iti.xml;

import java.io.File;
import java.lang.annotation.ElementType;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class App {


    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("Messages");
        document.appendChild(root);

        Element msg1 = document.createElement("Message");
        msg1.setAttribute("type", "info");

        Element from1 = document.createElement("From");
        from1.setTextContent("Khaled");

        Element to1 = document.createElement("To");
        to1.setTextContent("Adham");

        Element body1 = document.createElement("Body");
        body1.setTextContent("Hello!");

        msg1.appendChild(from1);
        msg1.appendChild(to1);
        msg1.appendChild(body1);

        root.appendChild(msg1);

        Element msg2 = document.createElement("Message");
        msg2.setAttribute("type", "warning");

        Element from2 = document.createElement("From");
        from2.setTextContent("System");

        Element to2 = document.createElement("To");
        to2.setTextContent("User");

        Element body2 = document.createElement("Body");
        body2.setTextContent("Low battery");

        msg2.appendChild(from2);
        msg2.appendChild(to2);
        msg2.appendChild(body2);

        root.appendChild(msg2);

        App app = new App();
        app.traverse(document);
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