package br.com.compras.backend.service.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.compras.backend.entity.Reserva;

@RepositoryRestResource(collectionResourceRel = "reserva", path = "reserva")
public interface ReservaRepository extends PagingAndSortingRepository<Reserva, Long> {

}
