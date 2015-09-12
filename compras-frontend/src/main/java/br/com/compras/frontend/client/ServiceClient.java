package br.com.compras.frontend.client;

import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.compras.frontend.client.rs.ClienteRest;
import br.com.compras.frontend.client.rs.CompraRest;
import br.com.compras.frontend.client.rs.ProdutoRest;
import br.com.compras.frontend.client.rs.ReservaRest;
import br.com.compras.frontend.client.services.ClienteService;
import br.com.compras.frontend.client.services.CompraService;
import br.com.compras.frontend.client.services.ProdutoService;
import br.com.compras.frontend.client.services.ReservaService;
import br.com.compras.frontend.client.ws.ClienteSoap;
import br.com.compras.frontend.client.ws.CompraSoap;
import br.com.compras.frontend.client.ws.ProdutoSoap;
import br.com.compras.frontend.client.ws.ReservaSoap;
import br.com.compras.frontend.client.ws.config.ClientAppConfig;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public class ServiceClient {
	
	private static ClienteSoap clienteSoap;
	private static ProdutoSoap produtoSoap;
	private static CompraSoap compraSoap;
	private static ReservaSoap reservaSoap;
	
	static{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(ClientAppConfig.class);
	    ctx.refresh();
		clienteSoap = ctx.getBean(ClienteSoap.class);
		produtoSoap = ctx.getBean(ProdutoSoap.class);
		compraSoap = ctx.getBean(CompraSoap.class);
		reservaSoap = ctx.getBean(ReservaSoap.class);
		ctx.close();
	}
	
	public static ClienteService getClienteService(ClientType clientType) {
		if (clientType == ClientType.REST) {
			return new ClienteRest(clientType.getApplicationURI());
		} else {
			return clienteSoap;
		}
	}
	
	public static ProdutoService getProdutoService(ClientType clientType) {
		if (clientType == ClientType.REST) {
			return new ProdutoRest(clientType.getApplicationURI());
		} else {
			return produtoSoap;
		}
	}
	
	public static CompraService getCompraService(ClientType clientType) {
		if (clientType == ClientType.REST) {
			return new CompraRest(clientType.getApplicationURI());
		} else {
			return compraSoap;
		}
	}
	
	public static ReservaService getReservaService(ClientType clientType) {
		if (clientType == ClientType.REST) {
			return new ReservaRest(clientType.getApplicationURI());
		} else {
			return reservaSoap;
		}
	}
	
	private static WebResource getWebResource(String serviceResource) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		
		WebResource webResource = client.resource(serviceResource);
		
		return webResource;
	}
	
	public static ClientResponse getClientResponseGET(String serviceResource) {
		WebResource webResource = getWebResource(serviceResource);
		
		return webResource.accept(MediaType.APPLICATION_JSON)
												   .type(MediaType.APPLICATION_JSON)
												   .get(ClientResponse.class);
		
	}
	
	public static ClientResponse getClientResponsePOST(String serviceResource, Object obj) {
		WebResource webResource = getWebResource(serviceResource);
		
		return webResource.accept(MediaType.APPLICATION_JSON)
				   								   .type(MediaType.APPLICATION_JSON)
				   								   .post(ClientResponse.class, obj);
	}
	
	public static ClientResponse getClientResponseDELETE(String serviceResource) {
		WebResource webResource = getWebResource(serviceResource);
		
		return webResource.delete(ClientResponse.class);
	}
}
