package br.com.compras.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.pojomatic.annotations.AutoProperty;

@Entity
@AutoProperty
public class Compra extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numero;
	private Calendar data;
	private String responsavel;
	private Situacao situacao;
	private BigDecimal valor;
	private Reserva reserva;
	private Cliente cliente;
	private List<Item> itens;
	
	public Long getNumero() {
		return numero;
	}

	public Calendar getData() {
		return data;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
