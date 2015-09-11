package br.com.compras.online.client.soap;

import java.util.List;

import br.com.compras.backend.entity.Compra;
import br.com.compras.online.client.services.CompraService;

public class CompraSoap implements CompraService {

	private final String applicationURI;
	
	public CompraSoap(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Compra findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compra save(Compra entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compra> findComprasMaiorQueQuinhentosReais() {
		// TODO Auto-generated method stub
		return null;
	}
}
