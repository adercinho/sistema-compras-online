package br.com.compras.backend;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import br.com.compras.backend.service.ws.endpoint.ClienteEndpoint;
import br.com.compras.backend.service.ws.endpoint.CompraEndpoint;
import br.com.compras.backend.service.ws.endpoint.ProdutoEndpoint;
import br.com.compras.backend.service.ws.endpoint.ReservaEndpoint;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		return new ServletRegistrationBean(servlet, "/*");
	}
	
	@Bean(name = "cliente")
	public DefaultWsdl11Definition defaultWsdl11DefinitionCliente(XsdSchema clienteSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ClientePort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace(ClienteEndpoint.NAMESPACE_URI);
		wsdl11Definition.setSchema(clienteSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "produto")
	public DefaultWsdl11Definition defaultWsdl11DefinitionProduto(XsdSchema produtoSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ProdutoPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace(ProdutoEndpoint.NAMESPACE_URI);
		wsdl11Definition.setSchema(produtoSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "reserva")
	public DefaultWsdl11Definition defaultWsdl11DefinitionReserva(XsdSchema reservaSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ReservaPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace(ReservaEndpoint.NAMESPACE_URI);
		wsdl11Definition.setSchema(reservaSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "compra")
	public DefaultWsdl11Definition defaultWsdl11DefinitionCompra(XsdSchema compraSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CompraPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace(CompraEndpoint.NAMESPACE_URI);
		wsdl11Definition.setSchema(compraSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema clienteSchema() {
		return new SimpleXsdSchema(new ClassPathResource("META-INF/schemas/cliente.xsd"));
	}
	@Bean
	public XsdSchema produtoSchema() {
		return new SimpleXsdSchema(new ClassPathResource("META-INF/schemas/produto.xsd"));
	}
	@Bean
	public XsdSchema reservaSchema() {
		return new SimpleXsdSchema(new ClassPathResource("META-INF/schemas/reserva.xsd"));
	}
	@Bean
	public XsdSchema compraSchema() {
		return new SimpleXsdSchema(new ClassPathResource("META-INF/schemas/compra.xsd"));
	}

}