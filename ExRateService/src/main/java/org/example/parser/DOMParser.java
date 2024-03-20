package org.example.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMParser {
    public static double getExchangeRate(InputStream xmlStream, String sourceCountry, String destinationCountry)

    {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlStream);
            NodeList currencyNodes = doc.getElementsByTagName("currency");
            for(int i=0;i< currencyNodes.getLength();i++){
                Element currencyElement = (Element) currencyNodes.item(i);
                String code = currencyElement.getElementsByTagName("code").item(0).getTextContent();
                String rateStr = currencyElement.getElementsByTagName("rate").item(0).getTextContent();
                double rate = Double.parseDouble(rateStr);
                if(sourceCountry.equals(code)){
                    for(int j=0;j<currencyNodes.getLength();j++){
                        Element currencyElement2 = (Element) currencyNodes.item(j);
                        String code2 = currencyElement2.getElementsByTagName("code").item(0).getTextContent();
                        String rateStr2 = currencyElement2.getElementsByTagName("rate").item(0).getTextContent();
                        double rate2 = Double.parseDouble(rateStr2);
                        if(destinationCountry.equals(code2)){
                            return rate2/rate;
                        }
                    }
                }
            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return 0;

    }


}
