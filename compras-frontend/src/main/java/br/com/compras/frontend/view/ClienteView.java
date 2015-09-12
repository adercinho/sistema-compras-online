package br.com.compras.frontend.view;

import java.util.List;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.frontend.client.ServiceClient;
import br.com.compras.frontend.client.services.ClienteService;
import br.com.compras.frontend.main.ComprasUI;
import br.com.compras.frontend.utils.BaseForm;
import br.com.compras.frontend.utils.DefaultWindow;
import br.com.compras.frontend.utils.Message;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
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
		Component header = super.buildHeader();
		
		Button exibir = new Button("Exibir clientes que realizaram reserva");
		exibir.setImmediate(true);
		exibir.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				ClienteService service = ServiceClient.getClienteService(ComprasUI.CLIENT_TYPE);
				container.populate(service.findClientesQueRealizamReservaProdutos());
			}
		});
		getHeader().addComponent(exibir);
		
		return header;
	}
	
	private Component buildTable() {
		Table table = new Table();
		table.setContainerDataSource(container);
		table.setSizeFull();
		table.setVisibleColumns("id", "nome", "endereco", "telefone");
		table.setColumnHeaders("Id", "Nome", "Endere�o", "Telefone");
		
		table.addGeneratedColumn("action", new TableColumnGenerator());
		table.setColumnHeader("action", "A��es");
		
		return table;
	}
	

	@Override
	public void incluir() {
		DefaultWindow.open(new IncluirWindow(), "Novo cliente", null, null);
	}

	@Override
	public void buscar() {
		ClienteService service = ServiceClient.getClienteService(ComprasUI.CLIENT_TYPE);
		Cliente cliente = service.findById(Long.parseLong(getTxtId().getValue()));
		container.populate(cliente);
	}

	@Override
	public void atualizar() {
		getTxtId().setValue(null);
		container.populate();
	}
	
	class TableContainer extends BeanItemContainer<Cliente> {

		public TableContainer()
				throws IllegalArgumentException {
			super(Cliente.class);
			populate();
		}
		
		public void populate() {
			try {
				removeAllItems();
				ClienteService service = ServiceClient.getClienteService(ComprasUI.CLIENT_TYPE);
				populate(service.findAll());
			} catch (Exception e) {
				Message.ERROR.show("Erro ao buscar os dados. Detalhes: " + e.getMessage());
			}
		}
		
		public void populate(List<Cliente> clienteList) {
			removeAllItems();
			addAll(clienteList);
		}
		
		public void populate(Cliente cliente) {
			removeAllItems();
			if (cliente != null)
				addItem(cliente);
		}
	}
	
	class TableColumnGenerator implements ColumnGenerator {
		public TableColumnGenerator() {}
		@Override
		public Object generateCell(Table source, Object itemId, Object columnId) {
			final Cliente cliente = (Cliente) itemId;
			if (columnId.toString().equals("action")) {
				Button excluir = new Button(FontAwesome.TRASH_O);
				excluir.addStyleName(ValoTheme.BUTTON_DANGER);
				excluir.addStyleName(ValoTheme.BUTTON_SMALL);
				excluir.setDescription("Excluir registro");
				excluir.setId("excluir");
				excluir.addClickListener(new ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						try {
//							if (cliente.getReservaList().isEmpty()) {
								ClienteService service = ServiceClient.getClienteService(ComprasUI.CLIENT_TYPE);
								service.delete(cliente.getId());
								container.removeItem(cliente);
								Message.DELETE_SUCCESS.show();
//							} else {
//								Message.ALERT.show("o cliente " + cliente.getNome() + " possui reservas efetuadas, "
//										+ "n�o ser� possivel exlui-lo");
//							}
						} catch (Exception e) {
							Message.ERROR.show("Erro ao exluir. Detalhes: " + e.getMessage());
						}
					}
				});
				return excluir;
			} else {
				return null;
			}
		}
	}
	
	class IncluirWindow extends BaseForm {
		
		private final FieldGroup binder;
		private final BeanItem<Cliente> item;
		private TextField nomeField;
		private TextField enderecoField;
		private TextField telefoneField;
		
		public IncluirWindow() {
			item = new BeanItem<Cliente>(new Cliente());
			binder = new FieldGroup(item);
			buildForm();
		}
		
		private void buildForm() {
			nomeField = new TextField("Nome");
			nomeField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			nomeField.setNullRepresentation("");
			nomeField.setImmediate(true);
			nomeField.setMaxLength(60);
			nomeField.setRequired(true);
			nomeField.setRequiredError("Nome � obrigat�rio");
			
			enderecoField = new TextField("Endere�o");
			enderecoField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			enderecoField.setNullRepresentation("");
			enderecoField.setImmediate(true);
			enderecoField.setMaxLength(60);
			enderecoField.setRequired(true);
			enderecoField.setRequiredError("Endere�o � obrigat�rio");
			
			telefoneField = new TextField("Telefone cliente");
			telefoneField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			telefoneField.setStyleName(ValoTheme.TEXTFIELD_ALIGN_RIGHT);
			telefoneField.setNullRepresentation("");
			telefoneField.setImmediate(true);
			telefoneField.setMaxLength(11);
			telefoneField.setRequired(true);
			telefoneField.setRequiredError("Telefone � obrigat�rio");
			
			binder.bind(nomeField, "nome");
			binder.bind(enderecoField, "endereco");
			binder.bind(telefoneField, "telefone");
			
			addComponent(nomeField);
			addComponent(enderecoField);
			addComponent(telefoneField);
		}

		@Override
		public void save() {
			try {
				if (binder.isValid()) {
					binder.commit();
					ClienteService service = ServiceClient.getClienteService(ComprasUI.CLIENT_TYPE);
					Cliente cliente = service.save(item.getBean());
					container.addItem(cliente);
					Message.SAVE_SUCCESS.show();
					if (getWindow() != null)
						getWindow().close();
				}
			} catch (Exception e) {
				Message.ERROR.show("Erro ao salvar. Detalhes: " + e.getMessage());
			}
			
		}

		@Override
		public void cancel() {
			if (getWindow() != null)
				getWindow().close();
		}
	}
}
