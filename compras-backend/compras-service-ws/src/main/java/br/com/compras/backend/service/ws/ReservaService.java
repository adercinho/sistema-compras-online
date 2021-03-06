package br.com.compras.backend.service.ws;

import java.util.List;

import br.com.compras.backend.entity.Reserva;
import br.com.compras.backend.exception.BusinessException;

public interface ReservaService {

	Reserva findById(Long id);
	List<Reserva> findAll();
	Reserva save(Reserva reserva) throws BusinessException;
	void delete(Long id);
		
}
