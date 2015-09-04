package br.com.compras.backend.service.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.compras.backend.entity.Produto;

@RepositoryRestResource(collectionResourceRel = "produto", path = "produto")
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

}
