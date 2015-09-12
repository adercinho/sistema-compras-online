package br.com.compras.frontend.client.ws;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import br.com.compras.backend.entity.Compra;
import br.com.compras.frontend.client.services.CompraService;
import br.com.compras.frontend.client.ws.complextype.compra.DeleteCompraRequest;
import br.com.compras.frontend.client.ws.complextype.compra.GetCompraRequest;
import br.com.compras.frontend.client.ws.complextype.compra.GetCompraResponse;
import br.com.compras.frontend.client.ws.complextype.compra.ListAllCompraRequest;
import br.com.compras.frontend.client.ws.complextype.compra.ListAllCompraResponse;
import br.com.compras.frontend.client.ws.complextype.compra.ListAllComprasMaiorQueQuinhentosReaisRequest;
import br.com.compras.frontend.client.ws.complextype.compra.ListAllComprasMaiorQueQuinhentosReaisResponse;
import br.com.compras.frontend.client.ws.complextype.compra.SaveCompraRequest;
import br.com.compras.frontend.client.ws.complextype.compra.SaveCompraResponse;

@Component
public class CompraSoap extends WebServiceGatewaySupport implements CompraService {

	private final String applicationURI;
	
	public CompraSoap(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Compra findById(Long id) {
		GetCompraRequest request = new GetCompraRequest();
		request.setId(id);
		GetCompraResponse response = (GetCompraResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getCompra();
	}

	@Override
	public List<Compra> findAll() {
		ListAllCompraRequest request = new ListAllCompraRequest();
		ListAllCompraResponse response = (ListAllCompraResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getAllCompras();
	}

	@Override
	public Compra save(Compra entity) {
		SaveCompraRequest request = new SaveCompraRequest();
		request.setCompra(entity);
		SaveCompraResponse response = (SaveCompraResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(applicationURI));
		return response.getCompra();
	}

	@Override
	public void delete(Long id) {
		DeleteCompraRequest request = new DeleteCompraRequest();
		request.setId(id);
		getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
	}

	@Override
	public List<Compra> findComprasMaiorQueQuinhentosReais() {
		ListAllComprasMaiorQueQuinhentosReaisRequest request = new ListAllComprasMaiorQueQuinhentosReaisRequest();
		ListAllComprasMaiorQueQuinhentosReaisResponse response = (ListAllComprasMaiorQueQuinhentosReaisResponse)
							getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getAllComprasMaiorQueQuinhentosReais();
	}
}
