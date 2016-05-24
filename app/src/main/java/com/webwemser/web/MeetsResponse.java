
package com.webwemser.web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für meetsResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="meetsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://web/}sessionResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="meets" type="{http://web/}meet" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "meetsResponse", propOrder = {
    "meets"
})
public class MeetsResponse
    extends SessionResponse
{

    @XmlElement(nillable = true)
    protected List<Meet> meets;

    /**
     * Gets the value of the meets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Meet }
     * 
     * 
     */
    public List<Meet> getMeets() {
        if (meets == null) {
            meets = new ArrayList<Meet>();
        }
        return this.meets;
    }

}
