import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.compras.backend.entity.Cliente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public class TesteMain {

	public static void main(String[] args) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		
		WebResource webResource = client.resource("http://localhost:8080/rs/cliente");
		
		ClientResponse clientResponse = webResource.accept("application/json")
												   .type("application/json")
												   .get(ClientResponse.class);
		
		
		if (clientResponse.getStatus() != 200) {
			throw new RuntimeException("Falha : código do erro HTTP : " + clientResponse.getStatus());
		}
		
		
		List<Cliente> list = clientResponse.getEntity(new GenericType<List<Cliente>>(){});
		list.forEach(o -> System.out.println(o.getNome()));
	}

}
