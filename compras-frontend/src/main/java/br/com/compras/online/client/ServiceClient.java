package br.com.compras.online.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import br.com.compras.online.client.rest.ClienteRest;
import br.com.compras.online.client.services.ClienteService;
import br.com.compras.online.client.soap.ClienteSoap;


public class ServiceClient {
	public static ClienteService getClienteService(ClientType clientType) {
		if (clientType == ClientType.REST) {
			return new ClienteRest(clientType.getApplicationURI());
		} else {
			return new ClienteSoap(clientType.getApplicationURI());
		}
	}
	
	public static ClientResponse getRestResponse(String serviceResource) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		
		WebResource webResource = client.resource(serviceResource);
		
		ClientResponse clientResponse = webResource.accept("application/json")
												   .type("application/json")
												   .get(ClientResponse.class);
		
		return clientResponse;
	}
}
