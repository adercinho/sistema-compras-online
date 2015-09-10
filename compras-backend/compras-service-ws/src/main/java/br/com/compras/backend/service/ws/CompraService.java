package br.com.compras.backend.service.ws;

import br.com.compras.backend.entity.Compra;
import br.com.compras.backend.exception.BusinessException;

public interface CompraService {

	Compra findById(Long id);
	Compra[] findAll();
	Compra[] findComprasMaiorQueQuinhentosReais();
	Compra save(Compra compra) throws BusinessException;
	void delete(Long id);
		
}
