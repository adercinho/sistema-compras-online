//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.11 às 02:24:57 AM BRT 
//


package br.com.compras.frontend.client.ws.complextype.compra;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.compras.backend.entity.Compra;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allComprasMaiorQueQuinhentosReais" type="{http://compras.com.br/backend/service/ws/complextype/compra}compra" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "allComprasMaiorQueQuinhentosReais"
})
@XmlRootElement(name = "listAllComprasMaiorQueQuinhentosReaisResponse")
public class ListAllComprasMaiorQueQuinhentosReaisResponse {

    @XmlElement(nillable = true)
    protected List<Compra> allComprasMaiorQueQuinhentosReais;

    /**
     * Gets the value of the allComprasMaiorQueQuinhentosReais property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allComprasMaiorQueQuinhentosReais property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllComprasMaiorQueQuinhentosReais().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Compra }
     * 
     * 
     */
    public List<Compra> getAllComprasMaiorQueQuinhentosReais() {
        if (allComprasMaiorQueQuinhentosReais == null) {
            allComprasMaiorQueQuinhentosReais = new ArrayList<Compra>();
        }
        return this.allComprasMaiorQueQuinhentosReais;
    }

}
