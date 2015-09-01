package br.com.compras.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.pojomatic.annotations.AutoProperty;

@Entity
@AutoProperty
public class Reserva extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	private Calendar data;
	private String atendente;
	private Situacao situacao;
	private BigDecimal valor;
	private Cliente cliente;

	public Long getCodigo() {
		return codigo;
	}

	public Calendar getData() {
		return data;
	}

	public String getAtendente() {
		return atendente;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
