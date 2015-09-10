package br.com.compras.backend.service.ws.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compras.backend.entity.Compra;
import br.com.compras.backend.entity.Reserva;
import br.com.compras.backend.exception.BusinessException;
import br.com.compras.backend.repository.CompraRepository;
import br.com.compras.backend.repository.ReservaRepository;
import br.com.compras.backend.service.ws.CompraService;

@Service
public class CompraServiceImpl implements CompraService{

	@Autowired
	private CompraRepository repository;
	@Autowired
	private ReservaRepository reservaRepository;
	
	public Compra findById( Long id) {
		return repository.findOne(id);
	}
	
	public Compra[] findAll() {
		List<Compra> lista = (List<Compra>) repository.findAll();
		return lista.toArray(new Compra[lista.size()]);
	}
	
	public Compra save(Compra compra) throws BusinessException {
		Reserva reserva = reservaRepository.findOne(compra.getReserva().getId());
		if(reserva == null){
			throw new BusinessException("Reserva não encontrada!");
		}
		compra.setReserva(reserva);
		return repository.save(compra);
	}
	
	public void delete(Long id) {
		repository.delete(repository.findOne(id));
	}

	public Compra[] findComprasMaiorQueQuinhentosReais() {
		List<Compra> lista = repository.findComprasMaiorQueQuinhentosReais();
		return lista.toArray(new Compra[lista.size()]);
	}
}
