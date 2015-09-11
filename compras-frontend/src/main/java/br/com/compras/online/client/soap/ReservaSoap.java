package br.com.compras.online.client.soap;

import java.util.List;

import br.com.compras.backend.entity.Reserva;
import br.com.compras.online.client.services.ReservaService;

public class ReservaSoap implements ReservaService {

	private final String applicationURI;
	
	public ReservaSoap(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Reserva findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva save(Reserva entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
