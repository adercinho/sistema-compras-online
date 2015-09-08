package br.com.compras.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.compras.backend.entity.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {

}
