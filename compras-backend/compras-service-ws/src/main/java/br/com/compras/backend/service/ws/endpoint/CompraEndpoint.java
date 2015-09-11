package br.com.compras.backend.service.ws.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.compras.backend.entity.Compra;
import br.com.compras.backend.exception.BusinessException;
import br.com.compras.backend.service.ws.CompraService;
import br.com.compras.backend.service.ws.complextype.compra.DeleteCompraRequest;
import br.com.compras.backend.service.ws.complextype.compra.DeleteCompraResponse;
import br.com.compras.backend.service.ws.complextype.compra.GetCompraRequest;
import br.com.compras.backend.service.ws.complextype.compra.GetCompraResponse;
import br.com.compras.backend.service.ws.complextype.compra.ListAllCompraRequest;
import br.com.compras.backend.service.ws.complextype.compra.ListAllCompraResponse;
import br.com.compras.backend.service.ws.complextype.compra.ListAllComprasMaiorQueQuinhentosReaisRequest;
import br.com.compras.backend.service.ws.complextype.compra.ListAllComprasMaiorQueQuinhentosReaisResponse;
import br.com.compras.backend.service.ws.complextype.compra.SaveCompraRequest;
import br.com.compras.backend.service.ws.complextype.compra.SaveCompraResponse;


@Endpoint
public class CompraEndpoint {

	public static final String NAMESPACE_URI = "http://compras.com.br/backend/service/ws/complextype/compra";
	@Autowired
	private CompraService compraService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCompraRequest")
	@ResponsePayload
	public GetCompraResponse getCompra(@RequestPayload GetCompraRequest request) {
		GetCompraResponse response = new GetCompraResponse();
		response.setCompra(compraService.findById(request.getId()));
		return response;
	}
		
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveCompraRequest")
	@ResponsePayload
	public SaveCompraResponse saveCompra(@RequestPayload SaveCompraRequest request) throws BusinessException {
		SaveCompraResponse response = new SaveCompraResponse();
		Compra entity = compraService.save(request.getCompra());
		response.setCompra(entity);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCompraRequest")
	@ResponsePayload
	public DeleteCompraResponse deleteCompra(@RequestPayload DeleteCompraRequest request) {
		DeleteCompraResponse response = new DeleteCompraResponse();
		compraService.delete(request.getId());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllCompraRequest")
	@ResponsePayload
	public ListAllCompraResponse listAllCompra(@RequestPayload ListAllCompraRequest request) {		
		ListAllCompraResponse response = new ListAllCompraResponse();
		List<Compra> compraList = new ArrayList<Compra>();
		Iterable<Compra> compraIt = compraService.findAll();
		for(Compra compra : compraIt){
			compraList.add(compra);
		}		
		response.getAllCompras().addAll(compraList);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllComprasMaiorQueQuinhentosReaisRequest")
	@ResponsePayload
	public ListAllComprasMaiorQueQuinhentosReaisResponse listAllComprasQueRealizamReservaProdutos(@RequestPayload ListAllComprasMaiorQueQuinhentosReaisRequest request) {		
		ListAllComprasMaiorQueQuinhentosReaisResponse response = new ListAllComprasMaiorQueQuinhentosReaisResponse();
		List<Compra> compraList = new ArrayList<Compra>();
		Iterable<Compra> compraIt = compraService.findComprasMaiorQueQuinhentosReais();
		for(Compra compra : compraIt){
			compraList.add(compra);
		}		
		response.getAllComprasMaiorQueQuinhentosReais().addAll(compraList);
		return response;
	}

}