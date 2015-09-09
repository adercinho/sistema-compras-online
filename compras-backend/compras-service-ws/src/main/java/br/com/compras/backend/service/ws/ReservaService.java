package br.com.compras.backend.service.ws;

import javax.jws.WebService;

import br.com.compras.backend.entity.Reserva;
import br.com.compras.backend.exception.BusinessException;

@WebService
public interface ReservaService {

	Reserva findById(Long id);
	Reserva[] findAll();
	Reserva save(Reserva reserva) throws BusinessException;
	void delete(Long id);
		
}
