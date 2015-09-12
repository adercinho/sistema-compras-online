package br.com.compras.frontend.client.ws;

import java.util.List;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import br.com.compras.backend.entity.Produto;
import br.com.compras.frontend.client.services.ProdutoService;
import br.com.compras.frontend.client.ws.complextype.produto.DeleteProdutoRequest;
import br.com.compras.frontend.client.ws.complextype.produto.GetProdutoRequest;
import br.com.compras.frontend.client.ws.complextype.produto.GetProdutoResponse;
import br.com.compras.frontend.client.ws.complextype.produto.ListAllProdutoRequest;
import br.com.compras.frontend.client.ws.complextype.produto.ListAllProdutoResponse;
import br.com.compras.frontend.client.ws.complextype.produto.ListAllProdutosMenorQueMilReaisRequest;
import br.com.compras.frontend.client.ws.complextype.produto.ListAllProdutosMenorQueMilReaisResponse;
import br.com.compras.frontend.client.ws.complextype.produto.SaveProdutoRequest;
import br.com.compras.frontend.client.ws.complextype.produto.SaveProdutoResponse;

public class ProdutoSoap extends WebServiceGatewaySupport implements ProdutoService {

	private final String applicationURI;
	
	public ProdutoSoap(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Produto findById(Long id) {
		GetProdutoRequest request = new GetProdutoRequest();
		request.setId(id);
		GetProdutoResponse response = (GetProdutoResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getProduto();
	}

	@Override
	public List<Produto> findAll() {
		ListAllProdutoRequest request = new ListAllProdutoRequest();
		ListAllProdutoResponse response = (ListAllProdutoResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getAllProdutos();
	}

	@Override
	public Produto save(Produto entity) {
		SaveProdutoRequest request = new SaveProdutoRequest();
		request.setProduto(entity);
		SaveProdutoResponse response = (SaveProdutoResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(applicationURI));
		return response.getProduto();
	}

	@Override
	public void delete(Long id) {
		DeleteProdutoRequest request = new DeleteProdutoRequest();
		request.setId(id);
		getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
	}

	@Override
	public List<Produto> findProdutosMenorQueMilReais() {
		ListAllProdutosMenorQueMilReaisRequest request = new ListAllProdutosMenorQueMilReaisRequest();
		ListAllProdutosMenorQueMilReaisResponse response = (ListAllProdutosMenorQueMilReaisResponse)
							getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getAllProdutosMenorQueMilReais();
	}
}
