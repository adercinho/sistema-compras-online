package br.com.compras.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.compras.backend.entity.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {

	@Query("select c from Compra c where c.valor > 500")
	List<Compra> findComprasMaiorQueQuinhentosReais();

}
