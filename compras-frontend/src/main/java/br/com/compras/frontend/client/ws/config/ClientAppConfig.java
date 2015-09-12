package br.com.compras.frontend.client.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import br.com.compras.frontend.client.ClientType;
import br.com.compras.frontend.client.ws.ClienteSoap;
import br.com.compras.frontend.client.ws.CompraSoap;
import br.com.compras.frontend.client.ws.ProdutoSoap;
import br.com.compras.frontend.client.ws.ReservaSoap;

@Configuration
public class ClientAppConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPaths("br.com.compras.frontend.client.ws.complextype.cliente",
				"br.com.compras.frontend.client.ws.complextype.compra",
				"br.com.compras.frontend.client.ws.complextype.produto",
				"br.com.compras.frontend.client.ws.complextype.reserva");
		return marshaller;
	}
	
	@Bean
	public ClienteSoap cliente(Jaxb2Marshaller marshaller) {
		ClienteSoap clienteSoap = new ClienteSoap(ClientType.SOAP.getApplicationURI());
		clienteSoap.setDefaultUri(ClientType.SOAP.getApplicationURI()+"/cliente.wsdl");
		clienteSoap.setMarshaller(marshaller);
		clienteSoap.setUnmarshaller(marshaller);
		return clienteSoap;
	}
	
	@Bean
	public CompraSoap compra(Jaxb2Marshaller marshaller) {
		CompraSoap compraSoap = new CompraSoap(ClientType.SOAP.getApplicationURI());
		compraSoap.setDefaultUri(ClientType.SOAP.getApplicationURI()+"/compra.wsdl");
		compraSoap.setMarshaller(marshaller);
		compraSoap.setUnmarshaller(marshaller);
		return compraSoap;
	}
	
	@Bean
	public ProdutoSoap produto(Jaxb2Marshaller marshaller) {
		ProdutoSoap produtoSoap = new ProdutoSoap(ClientType.SOAP.getApplicationURI());
		produtoSoap.setDefaultUri(ClientType.SOAP.getApplicationURI()+"/produto.wsdl");
		produtoSoap.setMarshaller(marshaller);
		produtoSoap.setUnmarshaller(marshaller);
		return produtoSoap;
	}
	
	@Bean
	public ReservaSoap reserva(Jaxb2Marshaller marshaller) {
		ReservaSoap reservaSoap = new ReservaSoap(ClientType.SOAP.getApplicationURI());
		reservaSoap.setDefaultUri(ClientType.SOAP.getApplicationURI()+"/reserva.wsdl");
		reservaSoap.setMarshaller(marshaller);
		reservaSoap.setUnmarshaller(marshaller);
		return reservaSoap;
	}
}
