package br.com.compras.backend.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.entity.Reserva;
import br.com.compras.backend.exception.BusinessException;
import br.com.compras.backend.repository.ClienteRepository;
import br.com.compras.backend.repository.ReservaRepository;


@RestController
@RequestMapping("/reserva")
public class ReservaService{

	@Autowired
	private ReservaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@ResponseBody
	@RequestMapping("/{id}")
	public Reserva findById(@PathVariable Long id) {
		return repository.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<Reserva> findAll() {
		return (List<Reserva>) repository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
	public Reserva save(@RequestBody Reserva reserva) throws BusinessException {
		Cliente cliente = clienteRepository.findOne(reserva.getCliente().getId());
		if(cliente == null){
			throw new BusinessException("Cliente não encontrado!");
		}
		reserva.setCliente(cliente);
		return repository.save(reserva);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repository.delete(repository.findOne(id));
	}
}
