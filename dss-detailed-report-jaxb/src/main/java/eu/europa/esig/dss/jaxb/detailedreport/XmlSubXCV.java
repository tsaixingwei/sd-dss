//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.05 at 01:41:30 PM CET 
//


package eu.europa.esig.dss.jaxb.detailedreport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubXCV complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubXCV"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dss.esig.europa.eu/validation/detailed-report}ConstraintsConclusion"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RFC" type="{http://dss.esig.europa.eu/validation/detailed-report}RFC" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TrustAnchor" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubXCV", propOrder = {
    "rfc"
})
public class XmlSubXCV
    extends XmlConstraintsConclusion
{

    @XmlElement(name = "RFC")
    protected XmlRFC rfc;
    @XmlAttribute(name = "Id", required = true)
    protected String id;
    @XmlAttribute(name = "TrustAnchor")
    protected Boolean trustAnchor;

    /**
     * Gets the value of the rfc property.
     * 
     * @return
     *     possible object is
     *     {@link XmlRFC }
     *     
     */
    public XmlRFC getRFC() {
        return rfc;
    }

    /**
     * Sets the value of the rfc property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlRFC }
     *     
     */
    public void setRFC(XmlRFC value) {
        this.rfc = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the trustAnchor property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTrustAnchor() {
        return trustAnchor;
    }

    /**
     * Sets the value of the trustAnchor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTrustAnchor(Boolean value) {
        this.trustAnchor = value;
    }

}
