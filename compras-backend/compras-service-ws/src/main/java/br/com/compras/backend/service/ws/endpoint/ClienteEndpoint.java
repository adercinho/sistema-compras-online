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
import br.com.compras.backend.service.ws.complextype.cliente.DeleteClienteRequest;
import br.com.compras.backend.service.ws.complextype.cliente.DeleteClienteResponse;
import br.com.compras.backend.service.ws.complextype.cliente.GetClienteRequest;
import br.com.compras.backend.service.ws.complextype.cliente.GetClienteResponse;
import br.com.compras.backend.service.ws.complextype.cliente.ListAllClienteRequest;
import br.com.compras.backend.service.ws.complextype.cliente.ListAllClienteResponse;
import br.com.compras.backend.service.ws.complextype.cliente.ListAllClientesQueRealizamReservaProdutosRequest;
import br.com.compras.backend.service.ws.complextype.cliente.ListAllClientesQueRealizamReservaProdutosResponse;
import br.com.compras.backend.service.ws.complextype.cliente.SaveClienteRequest;
import br.com.compras.backend.service.ws.complextype.cliente.SaveClienteResponse;


@Endpoint
public class ClienteEndpoint {

	public static final String NAMESPACE_URI = "http://compras.com.br/backend/service/ws/complextype/cliente";
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
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllClientesQueRealizamReservaProdutosRequest")
	@ResponsePayload
	public ListAllClientesQueRealizamReservaProdutosResponse listAllClientesQueRealizamReservaProdutos(@RequestPayload ListAllClientesQueRealizamReservaProdutosRequest request) {		
		ListAllClientesQueRealizamReservaProdutosResponse response = new ListAllClientesQueRealizamReservaProdutosResponse();
		List<Cliente> clienteList = new ArrayList<Cliente>();
		Iterable<Cliente> clienteIt = clienteService.findClientesQueRealizamReservaProdutos();
		for(Cliente cliente : clienteIt){
			clienteList.add(cliente);
		}		
		response.getAllClientesQueRealizamReservaProdutos().addAll(clienteList);
		return response;
	}

}