//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.11 às 02:24:57 AM BRT 
//


package br.com.compras.backend.service.ws.complextype.compra;

import javax.xml.bind.annotation.XmlRegistry;

import br.com.compras.backend.entity.Compra;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.compras.backend.service.ws.complextype.compra package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.compras.backend.service.ws.complextype.compra
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCompraRequest }
     * 
     */
    public GetCompraRequest createGetCompraRequest() {
        return new GetCompraRequest();
    }

    /**
     * Create an instance of {@link GetCompraResponse }
     * 
     */
    public GetCompraResponse createGetCompraResponse() {
        return new GetCompraResponse();
    }

    /**
     * Create an instance of {@link Compra }
     * 
     */
    public Compra createCompra() {
        return new Compra();
    }

    /**
     * Create an instance of {@link ListAllCompraRequest }
     * 
     */
    public ListAllCompraRequest createListAllCompraRequest() {
        return new ListAllCompraRequest();
    }

    /**
     * Create an instance of {@link SaveCompraRequest }
     * 
     */
    public SaveCompraRequest createSaveCompraRequest() {
        return new SaveCompraRequest();
    }

    /**
     * Create an instance of {@link ListAllCompraResponse }
     * 
     */
    public ListAllCompraResponse createListAllCompraResponse() {
        return new ListAllCompraResponse();
    }

    /**
     * Create an instance of {@link SaveCompraResponse }
     * 
     */
    public SaveCompraResponse createSaveCompraResponse() {
        return new SaveCompraResponse();
    }

    /**
     * Create an instance of {@link DeleteCompraResponse }
     * 
     */
    public DeleteCompraResponse createDeleteCompraResponse() {
        return new DeleteCompraResponse();
    }

    /**
     * Create an instance of {@link ListAllComprasMaiorQueQuinhentosReaisResponse }
     * 
     */
    public ListAllComprasMaiorQueQuinhentosReaisResponse createListAllComprasMaiorQueQuinhentosReaisResponse() {
        return new ListAllComprasMaiorQueQuinhentosReaisResponse();
    }

    /**
     * Create an instance of {@link DeleteCompraRequest }
     * 
     */
    public DeleteCompraRequest createDeleteCompraRequest() {
        return new DeleteCompraRequest();
    }

    /**
     * Create an instance of {@link ListAllComprasMaiorQueQuinhentosReaisRequest }
     * 
     */
    public ListAllComprasMaiorQueQuinhentosReaisRequest createListAllComprasMaiorQueQuinhentosReaisRequest() {
        return new ListAllComprasMaiorQueQuinhentosReaisRequest();
    }

}
