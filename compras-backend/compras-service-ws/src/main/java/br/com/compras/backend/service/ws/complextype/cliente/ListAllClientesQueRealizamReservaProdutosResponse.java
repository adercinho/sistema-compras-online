//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.11 às 02:24:57 AM BRT 
//


package br.com.compras.backend.service.ws.complextype.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.compras.backend.entity.Cliente;


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
 *         &lt;element name="allClientesQueRealizamReservaProdutos" type="{http://compras.com.br/backend/service/ws/complextype/cliente}cliente" maxOccurs="unbounded" minOccurs="0"/>
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
    "allClientesQueRealizamReservaProdutos"
})
@XmlRootElement(name = "listAllClientesQueRealizamReservaProdutosResponse")
public class ListAllClientesQueRealizamReservaProdutosResponse {

    @XmlElement(nillable = true)
    protected List<Cliente> allClientesQueRealizamReservaProdutos;

    /**
     * Gets the value of the allClientesQueRealizamReservaProdutos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allClientesQueRealizamReservaProdutos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllClientesQueRealizamReservaProdutos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cliente }
     * 
     * 
     */
    public List<Cliente> getAllClientesQueRealizamReservaProdutos() {
        if (allClientesQueRealizamReservaProdutos == null) {
            allClientesQueRealizamReservaProdutos = new ArrayList<Cliente>();
        }
        return this.allClientesQueRealizamReservaProdutos;
    }

}
