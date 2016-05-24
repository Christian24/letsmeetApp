
package com.webwemser.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für sessionResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="sessionResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://web/}returnCodeResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="session" type="{http://web/}sessionData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sessionResponse", propOrder = {
    "session"
})
@XmlSeeAlso({
    MeetsResponse.class,
    MeetResponse.class,
    CategoriesResponse.class
})
public class SessionResponse
    extends ReturnCodeResponse
{

    protected SessionData session;

    /**
     * Ruft den Wert der session-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SessionData }
     *     
     */
    public SessionData getSession() {
        return session;
    }

    /**
     * Legt den Wert der session-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionData }
     *     
     */
    public void setSession(SessionData value) {
        this.session = value;
    }

}
