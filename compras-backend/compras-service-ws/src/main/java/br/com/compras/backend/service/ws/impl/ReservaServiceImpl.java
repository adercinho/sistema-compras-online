package br.com.compras.backend.service.ws.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.entity.Reserva;
import br.com.compras.backend.exception.BusinessException;
import br.com.compras.backend.repository.ClienteRepository;
import br.com.compras.backend.repository.ReservaRepository;
import br.com.compras.backend.service.ws.ReservaService;

public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Reserva findById(Long id) {
		return repository.findOne(id);
	}
	
	@Override
	public List<Reserva> findAll() {
		return (List<Reserva>) repository.findAll();
	}
	
	@Override
	public Reserva save(Reserva reserva) throws BusinessException {
		Cliente cliente = clienteRepository.findOne(reserva.getCliente().getId());
		if(cliente == null){
			throw new BusinessException("Cliente não encontrado!");
		}
		reserva.setCliente(cliente);
		return repository.save(reserva);
	}
	
	@Override
	public void delete(Long id) {
		repository.delete(repository.findOne(id));
	}
}
