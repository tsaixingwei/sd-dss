//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.13 at 03:43:36 PM CEST 
//


package eu.europa.esig.jaxb.policy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnsignedAttributesConstraints complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnsignedAttributesConstraints">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CounterSignature" type="{http://dss.esig.europa.eu/validation/policy}LevelConstraint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnsignedAttributesConstraints", propOrder = {
    "counterSignature"
})
public class UnsignedAttributesConstraints {

    @XmlElement(name = "CounterSignature")
    protected LevelConstraint counterSignature;

    /**
     * Gets the value of the counterSignature property.
     * 
     * @return
     *     possible object is
     *     {@link LevelConstraint }
     *     
     */
    public LevelConstraint getCounterSignature() {
        return counterSignature;
    }

    /**
     * Sets the value of the counterSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelConstraint }
     *     
     */
    public void setCounterSignature(LevelConstraint value) {
        this.counterSignature = value;
    }

}
