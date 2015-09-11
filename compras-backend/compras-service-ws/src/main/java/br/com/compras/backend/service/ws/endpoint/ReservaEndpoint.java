package br.com.compras.backend.service.ws.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.compras.backend.entity.Reserva;
import br.com.compras.backend.exception.BusinessException;
import br.com.compras.backend.service.ws.ReservaService;
import br.com.compras.backend.service.ws.complextype.reserva.DeleteReservaRequest;
import br.com.compras.backend.service.ws.complextype.reserva.DeleteReservaResponse;
import br.com.compras.backend.service.ws.complextype.reserva.GetReservaRequest;
import br.com.compras.backend.service.ws.complextype.reserva.GetReservaResponse;
import br.com.compras.backend.service.ws.complextype.reserva.ListAllReservaRequest;
import br.com.compras.backend.service.ws.complextype.reserva.ListAllReservaResponse;
import br.com.compras.backend.service.ws.complextype.reserva.SaveReservaRequest;
import br.com.compras.backend.service.ws.complextype.reserva.SaveReservaResponse;


@Endpoint
public class ReservaEndpoint {

	public static final String NAMESPACE_URI = "http://compras.com.br/backend/service/ws/complextype/reserva";
	@Autowired
	private ReservaService reservaService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getReservaRequest")
	@ResponsePayload
	public GetReservaResponse getReserva(@RequestPayload GetReservaRequest request) {
		GetReservaResponse response = new GetReservaResponse();
		response.setReserva(reservaService.findById(request.getId()));
		return response;
	}
		
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveReservaRequest")
	@ResponsePayload
	public SaveReservaResponse saveReserva(@RequestPayload SaveReservaRequest request) throws BusinessException {
		SaveReservaResponse response = new SaveReservaResponse();
		Reserva entity = reservaService.save(request.getReserva());
		response.setReserva(entity);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteReservaRequest")
	@ResponsePayload
	public DeleteReservaResponse deleteReserva(@RequestPayload DeleteReservaRequest request) {
		DeleteReservaResponse response = new DeleteReservaResponse();
		reservaService.delete(request.getId());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllReservaRequest")
	@ResponsePayload
	public ListAllReservaResponse listAllReserva(@RequestPayload ListAllReservaRequest request) {		
		ListAllReservaResponse response = new ListAllReservaResponse();
		List<Reserva> reservaList = new ArrayList<Reserva>();
		Iterable<Reserva> reservaIt = reservaService.findAll();
		for(Reserva reserva : reservaIt){
			reservaList.add(reserva);
		}		
		response.getAllReservas().addAll(reservaList);
		return response;
	}

}