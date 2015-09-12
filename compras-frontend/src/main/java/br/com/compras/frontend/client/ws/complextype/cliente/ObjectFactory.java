//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.12 às 06:27:53 PM BRT 
//


package br.com.compras.frontend.client.ws.complextype.cliente;

import javax.xml.bind.annotation.XmlRegistry;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.entity.Produto;
import br.com.compras.frontend.client.ws.complextype.produto.DeleteProdutoRequest;
import br.com.compras.frontend.client.ws.complextype.produto.DeleteProdutoResponse;
import br.com.compras.frontend.client.ws.complextype.produto.GetProdutoRequest;
import br.com.compras.frontend.client.ws.complextype.produto.GetProdutoResponse;
import br.com.compras.frontend.client.ws.complextype.produto.ListAllProdutoRequest;
import br.com.compras.frontend.client.ws.complextype.produto.ListAllProdutoResponse;
import br.com.compras.frontend.client.ws.complextype.produto.ListAllProdutosMenorQueMilReaisRequest;
import br.com.compras.frontend.client.ws.complextype.produto.ListAllProdutosMenorQueMilReaisResponse;
import br.com.compras.frontend.client.ws.complextype.produto.SaveProdutoRequest;
import br.com.compras.frontend.client.ws.complextype.produto.SaveProdutoResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.compras.frontend.client.complextype.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetClienteRequest }
     * 
     */
    public GetClienteRequest createGetClienteRequest() {
        return new GetClienteRequest();
    }

    /**
     * Create an instance of {@link GetClienteResponse }
     * 
     */
    public GetClienteResponse createGetClienteResponse() {
        return new GetClienteResponse();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link SaveClienteRequest }
     * 
     */
    public SaveClienteRequest createSaveClienteRequest() {
        return new SaveClienteRequest();
    }

    /**
     * Create an instance of {@link SaveClienteResponse }
     * 
     */
    public SaveClienteResponse createSaveClienteResponse() {
        return new SaveClienteResponse();
    }

    /**
     * Create an instance of {@link ListAllClienteRequest }
     * 
     */
    public ListAllClienteRequest createListAllClienteRequest() {
        return new ListAllClienteRequest();
    }

    /**
     * Create an instance of {@link ListAllClienteResponse }
     * 
     */
    public ListAllClienteResponse createListAllClienteResponse() {
        return new ListAllClienteResponse();
    }

    /**
     * Create an instance of {@link ListAllClientesQueRealizamReservaProdutosRequest }
     * 
     */
    public ListAllClientesQueRealizamReservaProdutosRequest createListAllClientesQueRealizamReservaProdutosRequest() {
        return new ListAllClientesQueRealizamReservaProdutosRequest();
    }

    /**
     * Create an instance of {@link ListAllClientesQueRealizamReservaProdutosResponse }
     * 
     */
    public ListAllClientesQueRealizamReservaProdutosResponse createListAllClientesQueRealizamReservaProdutosResponse() {
        return new ListAllClientesQueRealizamReservaProdutosResponse();
    }

    /**
     * Create an instance of {@link DeleteClienteRequest }
     * 
     */
    public DeleteClienteRequest createDeleteClienteRequest() {
        return new DeleteClienteRequest();
    }

    /**
     * Create an instance of {@link DeleteClienteResponse }
     * 
     */
    public DeleteClienteResponse createDeleteClienteResponse() {
        return new DeleteClienteResponse();
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
     * Create an instance of {@link SaveProdutoResponse }
     * 
     */
    public SaveProdutoResponse createSaveProdutoResponse() {
        return new SaveProdutoResponse();
    }

    /**
     * Create an instance of {@link ListAllProdutoRequest }
     * 
     */
    public ListAllProdutoRequest createListAllProdutoRequest() {
        return new ListAllProdutoRequest();
    }

    /**
     * Create an instance of {@link ListAllProdutoResponse }
     * 
     */
    public ListAllProdutoResponse createListAllProdutoResponse() {
        return new ListAllProdutoResponse();
    }

    /**
     * Create an instance of {@link ListAllProdutosMenorQueMilReaisRequest }
     * 
     */
    public ListAllProdutosMenorQueMilReaisRequest createListAllProdutosMenorQueMilReaisRequest() {
        return new ListAllProdutosMenorQueMilReaisRequest();
    }

    /**
     * Create an instance of {@link ListAllProdutosMenorQueMilReaisResponse }
     * 
     */
    public ListAllProdutosMenorQueMilReaisResponse createListAllProdutosMenorQueMilReaisResponse() {
        return new ListAllProdutosMenorQueMilReaisResponse();
    }

    /**
     * Create an instance of {@link DeleteProdutoRequest }
     * 
     */
    public DeleteProdutoRequest createDeleteProdutoRequest() {
        return new DeleteProdutoRequest();
    }

    /**
     * Create an instance of {@link DeleteProdutoResponse }
     * 
     */
    public DeleteProdutoResponse createDeleteProdutoResponse() {
        return new DeleteProdutoResponse();
    }

}
