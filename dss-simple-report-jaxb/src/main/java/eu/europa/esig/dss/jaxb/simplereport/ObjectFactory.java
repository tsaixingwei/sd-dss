//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.13 at 03:49:19 PM CEST 
//


package eu.europa.esig.dss.jaxb.simplereport;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.europa.esig.dss.jaxb.simplereport package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.europa.esig.dss.jaxb.simplereport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SimpleReport }
     * 
     */
    public SimpleReport createSimpleReport() {
        return new SimpleReport();
    }

    /**
     * Create an instance of {@link XmlPolicy }
     * 
     */
    public XmlPolicy createXmlPolicy() {
        return new XmlPolicy();
    }

    /**
     * Create an instance of {@link XmlSignature }
     * 
     */
    public XmlSignature createXmlSignature() {
        return new XmlSignature();
    }

    /**
     * Create an instance of {@link XmlSignatureScope }
     * 
     */
    public XmlSignatureScope createXmlSignatureScope() {
        return new XmlSignatureScope();
    }

}
