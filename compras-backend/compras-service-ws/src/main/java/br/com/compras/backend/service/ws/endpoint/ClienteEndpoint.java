package br.com.compras.backend.service.ws.endpoint;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactoryConfigurationException;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import br.com.compras.backend.service.ws.ClienteService;

@Endpoint
public class ClienteEndpoint {

	private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";

	private XPathExpression<Element> startDateExpression;
	private XPathExpression<Element> endDateExpression;
	private XPathExpression<String> nameExpression;

	private ClienteService clienteService;

	@Autowired
	public ClienteEndpoint(ClienteService humanResourceService)
			throws JDOMException, XPathFactoryConfigurationException,
			XPathExpressionException {
		this.clienteService = humanResourceService;

		Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);

		XPathFactory xPathFactory = XPathFactory.instance();

		this.startDateExpression = xPathFactory.compile("//hr:StartDate",
				Filters.element(), null, namespace);
		this.endDateExpression = xPathFactory.compile("//hr:EndDate", Filters.element(),
				null, namespace);
		this.nameExpression = xPathFactory.compile(
				"concat(//hr:FirstName,' ',//hr:LastName)", Filters.fstring(), null,
				namespace);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "clienteRequest")
	public void handleClienteRequest(@RequestPayload Element clienteRequest)
			throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse(this.startDateExpression.evaluateFirst(clienteRequest).getText());
		Date endDate = dateFormat.parse(this.endDateExpression.evaluateFirst(clienteRequest).getText());
		String name = this.nameExpression.evaluateFirst(clienteRequest);

		this.clienteService.save(null);
	}

}
