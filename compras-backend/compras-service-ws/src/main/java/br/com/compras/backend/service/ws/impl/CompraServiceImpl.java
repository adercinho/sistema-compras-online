package br.com.compras.backend.service.ws.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.compras.backend.entity.Compra;
import br.com.compras.backend.entity.Reserva;
import br.com.compras.backend.exception.BusinessException;
import br.com.compras.backend.repository.CompraRepository;
import br.com.compras.backend.repository.ReservaRepository;
import br.com.compras.backend.service.ws.CompraService;

public class CompraServiceImpl implements CompraService{

	@Autowired
	private CompraRepository repository;
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Override
	public Compra findById( Long id) {
		return repository.findOne(id);
	}
	
	@Override
	public List<Compra> findAll() {
		return (List<Compra>) repository.findAll();
	}
	
	@Override
	public Compra save(Compra compra) throws BusinessException {
		Reserva reserva = reservaRepository.findOne(compra.getReserva().getId());
		if(reserva == null){
			throw new BusinessException("Reserva não encontrada!");
		}
		compra.setReserva(reserva);
		return repository.save(compra);
	}
	
	@Override
	public void delete(Long id) {
		repository.delete(repository.findOne(id));
	}
}
