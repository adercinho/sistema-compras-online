package br.com.compras.backend.service.ws;

import javax.jws.WebService;

import br.com.compras.backend.entity.Compra;
import br.com.compras.backend.exception.BusinessException;

@WebService
public interface CompraService {

	Compra findById(Long id);
	Compra[] findAll();
	Compra[] findComprasMaiorQueQuinhentosReais();
	Compra save(Compra compra) throws BusinessException;
	void delete(Long id);
		
}
