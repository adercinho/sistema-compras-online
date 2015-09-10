package br.com.compras.backend.service.ws.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.service.ws.ClienteService;
import br.com.compras.backend.service.ws.endpoint.soap.DeleteClienteRequest;
import br.com.compras.backend.service.ws.endpoint.soap.DeleteClienteResponse;
import br.com.compras.backend.service.ws.endpoint.soap.GetClienteRequest;
import br.com.compras.backend.service.ws.endpoint.soap.GetClienteResponse;
import br.com.compras.backend.service.ws.endpoint.soap.ListAllClienteRequest;
import br.com.compras.backend.service.ws.endpoint.soap.ListAllClienteResponse;
import br.com.compras.backend.service.ws.endpoint.soap.SaveClienteRequest;
import br.com.compras.backend.service.ws.endpoint.soap.SaveClienteResponse;


@Endpoint
public class ClienteEndpoint {

	private static final String NAMESPACE_URI = "http://mycompany.com/services/soap";
	@Autowired
	private ClienteService clienteService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClienteRequest")
	@ResponsePayload
	public GetClienteResponse getCliente(@RequestPayload GetClienteRequest request) {
		GetClienteResponse response = new GetClienteResponse();
		response.setCliente(clienteService.findById(request.getId()));
		return response;
	}
		
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveClienteRequest")
	@ResponsePayload
	public SaveClienteResponse saveCliente(@RequestPayload SaveClienteRequest request) {
		SaveClienteResponse response = new SaveClienteResponse();
		Cliente entity = clienteService.save(request.getCliente());
		response.setCliente(entity);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClienteRequest")
	@ResponsePayload
	public DeleteClienteResponse deleteCliente(@RequestPayload DeleteClienteRequest request) {
		DeleteClienteResponse response = new DeleteClienteResponse();
		clienteService.delete(request.getId());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllClienteRequest")
	@ResponsePayload
	public ListAllClienteResponse listAllCliente(@RequestPayload ListAllClienteRequest request) {		
		ListAllClienteResponse response = new ListAllClienteResponse();
		List<Cliente> clienteList = new ArrayList<Cliente>();
		Iterable<Cliente> clienteIt = clienteService.findAll();
		for(Cliente cliente : clienteIt){
			clienteList.add(cliente);
		}		
		response.getAllClientes().addAll(clienteList);
		return response;
	}

}