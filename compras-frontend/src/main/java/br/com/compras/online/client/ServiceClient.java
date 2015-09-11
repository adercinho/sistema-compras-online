package br.com.compras.online.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import br.com.compras.online.client.rest.ClienteRest;
import br.com.compras.online.client.rest.ProdutoRest;
import br.com.compras.online.client.services.ClienteService;
import br.com.compras.online.client.services.ProdutoService;
import br.com.compras.online.client.soap.ClienteSoap;
import br.com.compras.online.client.soap.ProdutoSoap;


public class ServiceClient {
	public static ClienteService getClienteService(ClientType clientType) {
		if (clientType == ClientType.REST) {
			return new ClienteRest(clientType.getApplicationURI());
		} else {
			return new ClienteSoap(clientType.getApplicationURI());
		}
	}
	
	public static ProdutoService getProdutoService(ClientType clientType) {
		if (clientType == ClientType.REST) {
			return new ProdutoRest(clientType.getApplicationURI());
		} else {
			return new ProdutoSoap(clientType.getApplicationURI());
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
