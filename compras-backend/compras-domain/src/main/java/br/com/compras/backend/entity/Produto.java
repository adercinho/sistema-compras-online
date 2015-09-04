package br.com.compras.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	private String descricao;
	private BigDecimal preco;
	private Integer estoque;

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

}
