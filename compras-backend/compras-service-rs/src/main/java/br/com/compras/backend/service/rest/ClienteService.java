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
import br.com.compras.backend.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteService{

	@Autowired
	protected ClienteRepository repository;
	
	@ResponseBody
	@RequestMapping("/{id}")
	public Cliente findById(@PathVariable Long id) {
		return repository.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> findAll() {
		return (List<Cliente>) repository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
	public Cliente save(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repository.delete(repository.findOne(id));
	}
}
