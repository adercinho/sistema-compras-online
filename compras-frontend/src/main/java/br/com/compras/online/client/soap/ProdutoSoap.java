package br.com.compras.online.client.soap;

import java.util.List;

import br.com.compras.backend.entity.Produto;
import br.com.compras.online.client.services.ProdutoService;

public class ProdutoSoap implements ProdutoService {

	private final String applicationURI;
	
	public ProdutoSoap(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Produto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto save(Produto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> findProdutosMenorQueMilReais() {
		// TODO Auto-generated method stub
		return null;
	}
}
