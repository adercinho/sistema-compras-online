package br.com.compras.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.pojomatic.annotations.AutoProperty;

@Entity
@AutoProperty
public class Item extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	private Integer quantidade;
	private BigDecimal valor;
	private Situacao situacao;
	private Compra compra;
	private Produto produto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public Compra getCompra() {
		return compra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
