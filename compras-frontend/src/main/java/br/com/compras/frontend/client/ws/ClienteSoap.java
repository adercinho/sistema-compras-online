package br.com.compras.frontend.client.ws;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.frontend.client.services.ClienteService;
import br.com.compras.frontend.client.ws.complextype.cliente.DeleteClienteRequest;
import br.com.compras.frontend.client.ws.complextype.cliente.GetClienteRequest;
import br.com.compras.frontend.client.ws.complextype.cliente.GetClienteResponse;
import br.com.compras.frontend.client.ws.complextype.cliente.ListAllClienteRequest;
import br.com.compras.frontend.client.ws.complextype.cliente.ListAllClienteResponse;
import br.com.compras.frontend.client.ws.complextype.cliente.ListAllClientesQueRealizamReservaProdutosRequest;
import br.com.compras.frontend.client.ws.complextype.cliente.ListAllClientesQueRealizamReservaProdutosResponse;
import br.com.compras.frontend.client.ws.complextype.cliente.SaveClienteRequest;
import br.com.compras.frontend.client.ws.complextype.cliente.SaveClienteResponse;

@Component
public class ClienteSoap extends WebServiceGatewaySupport implements ClienteService{

	private String applicationURI;
	
	public ClienteSoap(String applicationURI) {
		this.applicationURI = applicationURI;
	}
	
	@Override
	public Cliente findById(Long id) {
		GetClienteRequest request = new GetClienteRequest();
		request.setId(id);
		GetClienteResponse response = (GetClienteResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getCliente();
	}

	@Override
	public List<Cliente> findAll() {
		ListAllClienteRequest request = new ListAllClienteRequest();
		ListAllClienteResponse response = (ListAllClienteResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getAllClientes();
	}

	@Override
	public Cliente save(Cliente entity) {
		SaveClienteRequest request = new SaveClienteRequest();
		request.setCliente(entity);
		SaveClienteResponse response = (SaveClienteResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(applicationURI));
		return response.getCliente();
	}

	@Override
	public void delete(Long id) {
		DeleteClienteRequest request = new DeleteClienteRequest();
		request.setId(id);
		getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
	}

	@Override
	public List<Cliente> findClientesQueRealizamReservaProdutos() {
		ListAllClientesQueRealizamReservaProdutosRequest request = new ListAllClientesQueRealizamReservaProdutosRequest();
		ListAllClientesQueRealizamReservaProdutosResponse response = (ListAllClientesQueRealizamReservaProdutosResponse)
							getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getAllClientesQueRealizamReservaProdutos();
	}
}
