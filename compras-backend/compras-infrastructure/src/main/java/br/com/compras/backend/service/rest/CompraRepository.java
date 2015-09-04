package br.com.compras.backend.service.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.compras.backend.entity.Compra;

@RepositoryRestResource(collectionResourceRel = "compra", path = "compra")
public interface CompraRepository extends PagingAndSortingRepository<Compra, Long> {

}
