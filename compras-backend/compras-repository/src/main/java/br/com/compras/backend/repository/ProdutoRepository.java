package br.com.compras.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.compras.backend.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	@Query("select p from Produto p where p.preco < 1000")
	List<Produto> findProdutosMenorQueMilReais();

}
