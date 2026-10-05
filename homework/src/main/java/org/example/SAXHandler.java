package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
    private String firstName = "";
    private String lastName = "";
    private String title = "";

    private final StringBuilder fileContent = new StringBuilder();
    private final StringBuilder elementBuffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementBuffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementBuffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String value = elementBuffer.toString().trim();

        switch (qName) {
            case "firstName":
                firstName = value;
                break;
            case "lastName":
                lastName = value;
                break;
            case "title":
                title = value;
                break;
            case "line":
                fileContent.append(value).append(System.lineSeparator());
                break;
        }
    }

    public String getFileName() {
        String rawFileName = firstName + "_" + lastName + "_" + title;
        return rawFileName.replaceAll("[^a-zA-Z0-9-А-Яа-яЁё_]", "_") + ".txt";
    }

    public String getContent() {
        return fileContent.toString();
    }
}
