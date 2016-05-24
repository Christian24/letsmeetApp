
package com.webwemser.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für returnCodeResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="returnCodeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://web/}dataTransferObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="returnCode" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnCodeResponse", propOrder = {
    "returnCode"
})
@XmlSeeAlso({
    SessionResponse.class
})
public class ReturnCodeResponse
    extends DataTransferObject
{

    protected int returnCode;

    /**
     * Ruft den Wert der returnCode-Eigenschaft ab.
     * 
     */
    public int getReturnCode() {
        return returnCode;
    }

    /**
     * Legt den Wert der returnCode-Eigenschaft fest.
     * 
     */
    public void setReturnCode(int value) {
        this.returnCode = value;
    }

}
