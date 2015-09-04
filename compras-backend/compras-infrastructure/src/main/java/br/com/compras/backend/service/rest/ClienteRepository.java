package br.com.compras.backend.service.rest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.compras.backend.entity.Cliente;

@RepositoryRestResource(collectionResourceRel = "cliente", path = "cliente")
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

	List<Cliente> findByNome(@Param("nome") String nome);
}
