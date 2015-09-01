package br.com.compras.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.compras.backend.entity.Produto;

@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
