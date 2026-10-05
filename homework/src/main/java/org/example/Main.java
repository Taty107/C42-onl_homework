package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        parseDocumentUsingTwoMethods();
    }

    public static void parseDocumentUsingTwoMethods() throws ParserConfigurationException, IOException, SAXException {
        System.out.println("Пожалуйста выберите каким способом распарсить документ");
        System.out.println("1 - SAX");
        System.out.println("2 - DOM");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                parseDocumentUsingSAX();
                break;
            case 2:
                parseDocumentUsingDOM();
                break;
            default:
                System.out.println("Извините вы выбрали не существующий метод");
        }

    }

    private static void parseDocumentUsingDOM() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/main/java/org/example/xml_file.xml"));
        doc.getDocumentElement().normalize();

        String firstName = doc.getElementsByTagName("firstName").item(0).getTextContent();
        String lastName = doc.getElementsByTagName("lastName").item(0).getTextContent();
        String title = doc.getElementsByTagName("title").item(0).getTextContent();
        NodeList nLine = doc.getElementsByTagName("line");
        StringBuilder fileContent = new StringBuilder();

        for (int i = 0; i < nLine.getLength(); i++) {
            Node node = nLine.item(i);
            fileContent.append(node.getTextContent()).append(System.lineSeparator());
        }
        String rawFileName = firstName + "_" + lastName + "_" + title;
        String safeFileName = rawFileName.replaceAll("[^a-zA-Z0-9-А-Яа-яЁё_]", "_") + ".txt";
        Files.writeString(Path.of(safeFileName), fileContent);
    }

    private static void parseDocumentUsingSAX() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        SAXHandler saxHandler = new SAXHandler();
        saxParser.parse("src/main/java/org/example/xml_file.xml", saxHandler);

        String safeFileName = saxHandler.getFileName();
        Files.writeString(Path.of(safeFileName), saxHandler.getContent());
    }
}