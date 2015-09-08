package br.com.compras.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compras.backend.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	List<Cliente> findByNome(@Param("nome") String nome);
}
