//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.11 às 02:24:57 AM BRT 
//


package br.com.compras.backend.service.ws.complextype.reserva;

import javax.xml.bind.annotation.XmlRegistry;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.entity.Reserva;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.compras.backend.service.ws.complextype.reserva package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.compras.backend.service.ws.complextype.reserva
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListAllReservaRequest }
     * 
     */
    public ListAllReservaRequest createListAllReservaRequest() {
        return new ListAllReservaRequest();
    }

    /**
     * Create an instance of {@link GetReservaRequest }
     * 
     */
    public GetReservaRequest createGetReservaRequest() {
        return new GetReservaRequest();
    }

    /**
     * Create an instance of {@link GetReservaResponse }
     * 
     */
    public GetReservaResponse createGetReservaResponse() {
        return new GetReservaResponse();
    }

    /**
     * Create an instance of {@link Reserva }
     * 
     */
    public Reserva createReserva() {
        return new Reserva();
    }

    /**
     * Create an instance of {@link DeleteReservaRequest }
     * 
     */
    public DeleteReservaRequest createDeleteReservaRequest() {
        return new DeleteReservaRequest();
    }

    /**
     * Create an instance of {@link SaveReservaResponse }
     * 
     */
    public SaveReservaResponse createSaveReservaResponse() {
        return new SaveReservaResponse();
    }

    /**
     * Create an instance of {@link ListAllReservaResponse }
     * 
     */
    public ListAllReservaResponse createListAllReservaResponse() {
        return new ListAllReservaResponse();
    }

    /**
     * Create an instance of {@link SaveReservaRequest }
     * 
     */
    public SaveReservaRequest createSaveReservaRequest() {
        return new SaveReservaRequest();
    }

    /**
     * Create an instance of {@link DeleteReservaResponse }
     * 
     */
    public DeleteReservaResponse createDeleteReservaResponse() {
        return new DeleteReservaResponse();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

}
