/*
 * Clase para nuestro Handler de SAX para procesar el archivo RSS
 */
package com.ad03.ad03;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author Manuel
 */
public class Handler extends DefaultHandler {
    
    private ArrayList<String> titulares = new ArrayList<>();
    private String titularaux;

    boolean isItem = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("item")){
            isItem = true;
            //System.out.println("item");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("item")){
            isItem = false;
        }
        
        if (qName.equals("title") && isItem){
            titulares.add(titularaux);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        
        this.titularaux = new String(ch, start, length);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getTitulares() {
        return titulares;
    }

    
}
