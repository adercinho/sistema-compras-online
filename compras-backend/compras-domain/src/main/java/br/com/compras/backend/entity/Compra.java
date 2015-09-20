package br.com.compras.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numero;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	private String responsavel;
	private Situacao situacao;
	private BigDecimal valor;
	@ManyToOne
	@JoinColumn(name="ID_RESERVA")
	private Reserva reserva;
	
	public Compra() {
		setSituacao(Situacao.AGUARDANDO_PAGAMENTO);
		setData(new GregorianCalendar());
		setValor(new BigDecimal(0.0));
	}
	
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

}
