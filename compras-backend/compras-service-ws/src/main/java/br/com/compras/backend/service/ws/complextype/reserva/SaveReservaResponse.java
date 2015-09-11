//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.11 às 02:24:57 AM BRT 
//


package br.com.compras.backend.service.ws.complextype.reserva;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.compras.backend.entity.Reserva;


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
 *         &lt;element name="reserva" type="{http://compras.com.br/backend/service/ws/complextype/reserva}reserva"/>
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
    "reserva"
})
@XmlRootElement(name = "saveReservaResponse")
public class SaveReservaResponse {

    @XmlElement(required = true)
    protected Reserva reserva;

    /**
     * Obtém o valor da propriedade reserva.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * Define o valor da propriedade reserva.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setReserva(Reserva value) {
        this.reserva = value;
    }

}
