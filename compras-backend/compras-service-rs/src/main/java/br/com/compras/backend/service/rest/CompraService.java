package br.com.compras.backend.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compras.backend.entity.Compra;
import br.com.compras.backend.entity.Reserva;
import br.com.compras.backend.exception.BusinessException;
import br.com.compras.backend.repository.CompraRepository;
import br.com.compras.backend.repository.ReservaRepository;

@RestController
@RequestMapping("/compra")
public class CompraService{

	@Autowired
	private CompraRepository repository;
	@Autowired
	private ReservaRepository reservaRepository;
	
	@ResponseBody
	@RequestMapping("/{id}")
	public Compra findById(@PathVariable Long id) {
		return repository.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<Compra> findAll() {
		return (List<Compra>) repository.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/findComprasMaiorQueQuinhentosReais")
	public List<Compra> findComprasMaiorQueQuinhentosReais() {
		return repository.findComprasMaiorQueQuinhentosReais();
	}
	
	@ResponseBody
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
	public Compra save(@RequestBody Compra compra) throws BusinessException {
		Reserva reserva = reservaRepository.findOne(compra.getReserva().getId());
		if(reserva == null){
			throw new BusinessException("Reserva não encontrada!");
		}
		compra.setReserva(reserva);
		return repository.save(compra);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repository.delete(repository.findOne(id));
	}
}
