//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.11 às 02:24:57 AM BRT 
//


package br.com.compras.backend.service.ws.complextype.cliente;

import javax.xml.bind.annotation.XmlRegistry;

import br.com.compras.backend.entity.Cliente;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.compras.backend.service.ws.complextype.cliente package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.compras.backend.service.ws.complextype.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListAllClientesQueRealizamReservaProdutosResponse }
     * 
     */
    public ListAllClientesQueRealizamReservaProdutosResponse createListAllClientesQueRealizamReservaProdutosResponse() {
        return new ListAllClientesQueRealizamReservaProdutosResponse();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link GetClienteResponse }
     * 
     */
    public GetClienteResponse createGetClienteResponse() {
        return new GetClienteResponse();
    }

    /**
     * Create an instance of {@link ListAllClienteResponse }
     * 
     */
    public ListAllClienteResponse createListAllClienteResponse() {
        return new ListAllClienteResponse();
    }

    /**
     * Create an instance of {@link ListAllClienteRequest }
     * 
     */
    public ListAllClienteRequest createListAllClienteRequest() {
        return new ListAllClienteRequest();
    }

    /**
     * Create an instance of {@link GetClienteRequest }
     * 
     */
    public GetClienteRequest createGetClienteRequest() {
        return new GetClienteRequest();
    }

    /**
     * Create an instance of {@link SaveClienteRequest }
     * 
     */
    public SaveClienteRequest createSaveClienteRequest() {
        return new SaveClienteRequest();
    }

    /**
     * Create an instance of {@link ListAllClientesQueRealizamReservaProdutosRequest }
     * 
     */
    public ListAllClientesQueRealizamReservaProdutosRequest createListAllClientesQueRealizamReservaProdutosRequest() {
        return new ListAllClientesQueRealizamReservaProdutosRequest();
    }

    /**
     * Create an instance of {@link DeleteClienteResponse }
     * 
     */
    public DeleteClienteResponse createDeleteClienteResponse() {
        return new DeleteClienteResponse();
    }

    /**
     * Create an instance of {@link DeleteClienteRequest }
     * 
     */
    public DeleteClienteRequest createDeleteClienteRequest() {
        return new DeleteClienteRequest();
    }

    /**
     * Create an instance of {@link SaveClienteResponse }
     * 
     */
    public SaveClienteResponse createSaveClienteResponse() {
        return new SaveClienteResponse();
    }

}
