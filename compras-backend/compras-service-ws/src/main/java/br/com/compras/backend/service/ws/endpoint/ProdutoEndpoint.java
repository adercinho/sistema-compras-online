package br.com.compras.backend.service.ws.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.compras.backend.entity.Produto;
import br.com.compras.backend.service.ws.ProdutoService;
import br.com.compras.backend.service.ws.complextype.produto.DeleteProdutoRequest;
import br.com.compras.backend.service.ws.complextype.produto.DeleteProdutoResponse;
import br.com.compras.backend.service.ws.complextype.produto.GetProdutoRequest;
import br.com.compras.backend.service.ws.complextype.produto.GetProdutoResponse;
import br.com.compras.backend.service.ws.complextype.produto.ListAllProdutoRequest;
import br.com.compras.backend.service.ws.complextype.produto.ListAllProdutoResponse;
import br.com.compras.backend.service.ws.complextype.produto.ListAllProdutosMenorQueMilReaisRequest;
import br.com.compras.backend.service.ws.complextype.produto.ListAllProdutosMenorQueMilReaisResponse;
import br.com.compras.backend.service.ws.complextype.produto.SaveProdutoRequest;
import br.com.compras.backend.service.ws.complextype.produto.SaveProdutoResponse;


@Endpoint
public class ProdutoEndpoint {

	public static final String NAMESPACE_URI = "http://compras.com.br/backend/service/ws/complextype/produto";
	@Autowired
	private ProdutoService produtoService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProdutoRequest")
	@ResponsePayload
	public GetProdutoResponse getProduto(@RequestPayload GetProdutoRequest request) {
		GetProdutoResponse response = new GetProdutoResponse();
		response.setProduto(produtoService.findById(request.getId()));
		return response;
	}
		
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveProdutoRequest")
	@ResponsePayload
	public SaveProdutoResponse saveProduto(@RequestPayload SaveProdutoRequest request) {
		SaveProdutoResponse response = new SaveProdutoResponse();
		Produto entity = produtoService.save(request.getProduto());
		response.setProduto(entity);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProdutoRequest")
	@ResponsePayload
	public DeleteProdutoResponse deleteProduto(@RequestPayload DeleteProdutoRequest request) {
		DeleteProdutoResponse response = new DeleteProdutoResponse();
		produtoService.delete(request.getId());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllProdutoRequest")
	@ResponsePayload
	public ListAllProdutoResponse listAllProduto(@RequestPayload ListAllProdutoRequest request) {		
		ListAllProdutoResponse response = new ListAllProdutoResponse();
		List<Produto> produtoList = new ArrayList<Produto>();
		Iterable<Produto> produtoIt = produtoService.findAll();
		for(Produto produto : produtoIt){
			produtoList.add(produto);
		}		
		response.getAllProdutos().addAll(produtoList);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllProdutosMenorQueMilReaisRequest")
	@ResponsePayload
	public ListAllProdutosMenorQueMilReaisResponse listAllProdutosMenorQueMilReais(@RequestPayload ListAllProdutosMenorQueMilReaisRequest request) {		
		ListAllProdutosMenorQueMilReaisResponse response = new ListAllProdutosMenorQueMilReaisResponse();
		List<Produto> produtoList = new ArrayList<Produto>();
		Iterable<Produto> produtoIt = produtoService.findProdutosMenorQueMilReais();
		for(Produto produto : produtoIt){
			produtoList.add(produto);
		}		
		response.getAllProdutosMenorQueMilReais().addAll(produtoList);
		return response;
	}

}