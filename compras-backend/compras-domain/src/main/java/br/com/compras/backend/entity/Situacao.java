package br.com.compras.backend.entity;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;


public enum Situacao {
	AGUARDANDO_PAGAMENTO("Aguardando pagamento"), 
	PAGO("Pago"), 
	FINALIZADO("Finalizado");

	private String descricao;
	private Situacao(String descricao) {
		this.descricao = descricao;
	}

	@JsonCreator
	public static Situacao forValue(String value) {
		return Situacao.valueOf(value.toUpperCase());
	}

	@JsonValue
	public String toValue() {
		return this.name();
	}

	@Override
	public String toString() {
		return descricao;
	}
}
