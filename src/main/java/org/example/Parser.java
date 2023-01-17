package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Parser {
    private ArrayList<Veicolo> veicoli;

    public Parser() {
        veicoli = new ArrayList<Veicolo>();
    }

    private Veicolo getVeicolo(Element element) {
        NodeList misura = element.getElementsByTagName("misura");;
        Veicolo veicolo;

        String id = getTextValue(element, "ID");
        veicolo = new Veicolo(id);

        for(int i=0; i<misura.getLength(); i++){
            veicolo.setMisura(new Misura(Float.parseFloat(getTextValue((Element) misura.item(i),"temperatura")), (getDatetimeValue((((Element) misura.item(i))), "data_ora")).getTime()), i);
        }

        return veicolo;
    }

    public ArrayList<Veicolo> parseDocument(String filename) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Veicolo veicolo;

        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();

        nodelist = root.getElementsByTagName("veicolo");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                veicolo = getVeicolo(element);
                veicoli.add(veicolo);
            }
        }

        return veicoli;
    }

    private String getTextValue(Element element, String tag) {
        String value = null;
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);
        if (nodelist != null && nodelist.getLength() > 0) {
            value = nodelist.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    private java.util.Date getDatetimeValue(Element element, String tag) {
        Date datetime;
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        try {
            datetime  = DatatypeFactory.newInstance().newXMLGregorianCalendar(getTextValue(element, tag)).toGregorianCalendar().getTime();
        }
        catch (DatatypeConfigurationException e) {
            datetime = null;
        }
        return datetime;
    }
}
