package br.com.compras.frontend.client;

public enum ClientType {
	REST("REST", "http://localhost:8081/rs"),
	SOAP("SOAP", "http://localhost:8082/ws");

	private String value;
	private String applicationUri;
	
	private ClientType(String value, String applicationUri) {
		this.value = value;
		this.applicationUri = applicationUri;
	}
	
	public String getApplicationURI() {
		return applicationUri;
	}

	public static ClientType fromString(String value) {

		if (REST.value.equalsIgnoreCase(value)) {
			return REST;
		}

		if (SOAP.value.equalsIgnoreCase(value)) {
			return SOAP;
		}

		return null;
	}
	
	@Override
	public String toString() {
		return value;
	}
};