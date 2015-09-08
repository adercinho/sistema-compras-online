package br.com.compras.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.compras.backend.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	@Query("select distinct c from Cliente c, Reserva r WHERE c.id = r.cliente.id ORDER BY c.nome")
	List<Cliente> findClientesQueRealizamReservaProdutos();
}
