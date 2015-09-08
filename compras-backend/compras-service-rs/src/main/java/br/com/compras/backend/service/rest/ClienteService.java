package br.com.compras.backend.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.repository.ClienteRepository;

@RestController("/cliente")
public class ClienteService{

	@Autowired
	protected ClienteRepository clienteRepository;
	
	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente findById(@RequestParam Long id) {
		return clienteRepository.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestParam Long id) {
		clienteRepository.delete(clienteRepository.findOne(id));
	}
}
