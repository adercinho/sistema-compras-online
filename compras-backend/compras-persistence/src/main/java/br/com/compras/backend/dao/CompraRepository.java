package br.com.compras.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.compras.backend.entity.Compra;

@Transactional
public interface CompraRepository extends JpaRepository<Compra, Long> {
    
}
