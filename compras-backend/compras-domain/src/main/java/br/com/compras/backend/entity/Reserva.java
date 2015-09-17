package br.com.compras.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_RESERVA")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	private String atendente;
	@Enumerated
	private Situacao situacao;
	private BigDecimal valor;
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	public Reserva() {
		setData(new GregorianCalendar());
		setSituacao(Situacao.AGUARDANDO_PAGAMENTO);
		setValor(new BigDecimal(0.0));
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", data=" + data + ", atendente="
				+ atendente + ", situacao=" + situacao + ", valor=" + valor
				+ ", cliente=" + cliente + "]";
	}
	
	
}
