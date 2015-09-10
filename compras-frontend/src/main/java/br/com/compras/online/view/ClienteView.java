package br.com.compras.online.view;

import java.util.List;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.online.client.ServiceClient;
import br.com.compras.online.client.services.ClienteService;
import br.com.compras.online.main.ComprasUI;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ClienteView extends BaseView {
	private final VerticalLayout verticalLayout = new VerticalLayout();
	private final TableContainer container = new TableContainer();

	public ClienteView() {
		buildView();
		addTab(verticalLayout, "Cliente", false);
	}

	public void buildView() {
		verticalLayout.setMargin(true);
		verticalLayout.setSpacing(true);
		verticalLayout.addComponent(buildHeader());
		verticalLayout.addComponent(buildTable());
	}
	
	public Component buildHeader() {
		VerticalLayout header = new VerticalLayout();
		header.addStyleName(ValoTheme.WINDOW_TOP_TOOLBAR);
		
		HorizontalLayout h1 = new HorizontalLayout();
		h1.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
		h1.setSpacing(true);
		Button incluir = new Button("Incluir", FontAwesome.STAR);
		incluir.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		incluir.setImmediate(true);
		incluir.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
			}
		});
		
		Button exibir = new Button("Exibir clientes que realizaram reserva");
		exibir.setImmediate(true);
		exibir.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
			}
		});
		
		CssLayout h2 = new CssLayout();
		h2.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		
		TextField txtId = new TextField();
		txtId.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		txtId.setImmediate(true);
		txtId.setInputPrompt("ID");
		txtId.setNullRepresentation("");
		txtId.setIcon(FontAwesome.SEARCH);
		txtId.setConverter(Long.class);
		
		Button buscar = new Button(FontAwesome.SEARCH);
		buscar.setImmediate(true);
		buscar.addStyleName(ValoTheme.BUTTON_PRIMARY);
		buscar.setClickShortcut(KeyCode.ENTER);
		buscar.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if (txtId.getValue() != null && !txtId.getValue().isEmpty()) {
					ClienteService service = ServiceClient.getClienteService(ComprasUI.CLIENT_TYPE);
					Cliente cliente = service.findById(Long.parseLong(txtId.getValue()));
					if (cliente != null)
						container.populate(cliente);
					else
						container.removeAllItems();
				}
			}
		});
		
		h2.addComponent(txtId);
		h2.addComponent(buscar);
		
		h1.addComponent(h2);
		h1.addComponent(incluir);
		h1.addComponent(exibir);
		
		header.addComponent(h1);
		return header;
	}
	
	private Component buildTable() {
		Table table = new Table();
		table.setContainerDataSource(container);
		return table;
	}
	
	class TableContainer extends BeanItemContainer<Cliente> {

		public TableContainer()
				throws IllegalArgumentException {
			super(Cliente.class);
			populate();
		}
		
		public void populate() {
			ClienteService service = ServiceClient.getClienteService(ComprasUI.CLIENT_TYPE);
			populate(service.findAll());
		}
		
		public void populate(List<Cliente> clienteList) {
			removeAllItems();
			addAll(clienteList);
		}
		
		public void populate(Cliente cliente) {
			removeAllItems();
			addItem(cliente);
		}
	}
}
