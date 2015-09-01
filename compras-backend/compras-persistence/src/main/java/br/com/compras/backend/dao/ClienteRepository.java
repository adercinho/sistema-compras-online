package br.com.compras.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.compras.backend.entity.Cliente;

@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
