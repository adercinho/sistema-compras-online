//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.11 às 02:24:57 AM BRT 
//


package br.com.compras.backend.service.ws.complextype.produto;

import javax.xml.bind.annotation.XmlRegistry;

import br.com.compras.backend.entity.Produto;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.compras.backend.service.ws.complextype.produto package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.compras.backend.service.ws.complextype.produto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListAllProdutoResponse }
     * 
     */
    public ListAllProdutoResponse createListAllProdutoResponse() {
        return new ListAllProdutoResponse();
    }

    /**
     * Create an instance of {@link Produto }
     * 
     */
    public Produto createProduto() {
        return new Produto();
    }

    /**
     * Create an instance of {@link SaveProdutoRequest }
     * 
     */
    public SaveProdutoRequest createSaveProdutoRequest() {
        return new SaveProdutoRequest();
    }

    /**
     * Create an instance of {@link ListAllProdutosMenorQueMilReaisResponse }
     * 
     */
    public ListAllProdutosMenorQueMilReaisResponse createListAllProdutosMenorQueMilReaisResponse() {
        return new ListAllProdutosMenorQueMilReaisResponse();
    }

    /**
     * Create an instance of {@link GetProdutoRequest }
     * 
     */
    public GetProdutoRequest createGetProdutoRequest() {
        return new GetProdutoRequest();
    }

    /**
     * Create an instance of {@link GetProdutoResponse }
     * 
     */
    public GetProdutoResponse createGetProdutoResponse() {
        return new GetProdutoResponse();
    }

    /**
     * Create an instance of {@link DeleteProdutoRequest }
     * 
     */
    public DeleteProdutoRequest createDeleteProdutoRequest() {
        return new DeleteProdutoRequest();
    }

    /**
     * Create an instance of {@link ListAllProdutoRequest }
     * 
     */
    public ListAllProdutoRequest createListAllProdutoRequest() {
        return new ListAllProdutoRequest();
    }

    /**
     * Create an instance of {@link DeleteProdutoResponse }
     * 
     */
    public DeleteProdutoResponse createDeleteProdutoResponse() {
        return new DeleteProdutoResponse();
    }

    /**
     * Create an instance of {@link ListAllProdutosMenorQueMilReaisRequest }
     * 
     */
    public ListAllProdutosMenorQueMilReaisRequest createListAllProdutosMenorQueMilReaisRequest() {
        return new ListAllProdutosMenorQueMilReaisRequest();
    }

    /**
     * Create an instance of {@link SaveProdutoResponse }
     * 
     */
    public SaveProdutoResponse createSaveProdutoResponse() {
        return new SaveProdutoResponse();
    }

}
