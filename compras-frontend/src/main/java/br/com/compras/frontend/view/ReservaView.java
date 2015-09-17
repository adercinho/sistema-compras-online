package br.com.compras.frontend.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.entity.Reserva;
import br.com.compras.frontend.client.ServiceClient;
import br.com.compras.frontend.client.services.ClienteService;
import br.com.compras.frontend.client.services.ReservaService;
import br.com.compras.frontend.main.ComprasUI;
import br.com.compras.frontend.utils.BaseDateField;
import br.com.compras.frontend.utils.BaseForm;
import br.com.compras.frontend.utils.DefaultWindow;
import br.com.compras.frontend.utils.Message;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ReservaView extends BaseView {
	private final VerticalLayout verticalLayout = new VerticalLayout();
	private final TableContainer container = new TableContainer();

	public ReservaView() {
		buildView();
		addTab(verticalLayout, "Reserva", false);
	}

	public void buildView() {
		verticalLayout.setMargin(true);
		verticalLayout.setSpacing(true);
		verticalLayout.addComponent(buildHeader());
		verticalLayout.addComponent(buildTable());
	}
	
	private Component buildTable() {
		Table table = new Table() {
			@Override
            protected String formatPropertyValue(Object rowId, Object colId,
                    Property<?> property) {
                Object v = property.getValue();
                if (v instanceof Calendar) {
                	Calendar value = (Calendar) v;
                    return new SimpleDateFormat("d/M/yy").format(value.getTime());
                } else if (v instanceof Cliente) {
                	Cliente value = (Cliente) v;
                    return value.getNome();
                }
                return super.formatPropertyValue(rowId, colId, property);
            }
		};
		table.setContainerDataSource(container);
		table.setSizeFull();
		table.setVisibleColumns("id", "situacao", "cliente", "atendente", "data", "valor");
		table.setColumnHeaders("Id", "Situação", "Cliente", "Atendente", "Data da reserva", "Valor");
		
		table.addGeneratedColumn("action", new TableColumnGenerator());
		table.setColumnHeader("action", "Ações");
		
		return table;
	}
	

	@Override
	public void incluir() {
		DefaultWindow.open(new IncluirWindow(), "Nova reserva", null, null);
	}

	@Override
	public void buscar() {
		ReservaService service = ServiceClient.getReservaService(ComprasUI.CLIENT_TYPE);
		Reserva reserva = service.findById(Long.parseLong(getTxtId().getValue()));
		container.populate(reserva);
	}

	@Override
	public void atualizar() {
		getTxtId().setValue(null);
		container.populate();
	}
	
	class TableContainer extends BeanItemContainer<Reserva> {

		public TableContainer()
				throws IllegalArgumentException {
			super(Reserva.class);
			populate();
		}
		
		public void populate() {
			try {
				removeAllItems();
				ReservaService service = ServiceClient.getReservaService(ComprasUI.CLIENT_TYPE);
				populate(service.findAll());
			} catch (Exception e) {
				Message.ERROR.show("Erro ao buscar os dados. Detalhes: " + e.getMessage());
			}
		}
		
		public void populate(List<Reserva> reservaList) {
			removeAllItems();
			addAll(reservaList);
		}
		
		public void populate(Reserva reserva) {
			removeAllItems();
			if (reserva != null)
				addItem(reserva);
		}
	}
	
	class TableColumnGenerator implements ColumnGenerator {
		public TableColumnGenerator() {}
		@Override
		public Object generateCell(Table source, Object itemId, Object columnId) {
			final Reserva reserva = (Reserva) itemId;
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
							ReservaService service = ServiceClient.getReservaService(ComprasUI.CLIENT_TYPE);
							service.delete(reserva.getId());
							container.removeItem(reserva);
							Message.DELETE_SUCCESS.show();
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
		private final BeanItem<Reserva> item;
		private ComboBox clienteField;
		private TextField atendenteField;
		private DateField dataField;
		
		public IncluirWindow() {
			item = new BeanItem<Reserva>(new Reserva());
			binder = new FieldGroup(item);
			buildForm();
		}
		
		@SuppressWarnings("unchecked")
		private void buildForm() {
			clienteField = new ComboBox("Cliente");
			clienteField.setStyleName(ValoTheme.COMBOBOX_SMALL);
			clienteField.setImmediate(true);
			clienteField.setRequired(true);
			clienteField.setRequiredError(clienteField.getCaption() + " é obrigatório");
			clienteField.setNullSelectionAllowed(false);
			clienteField.setFilteringMode(FilteringMode.CONTAINS);
			clienteField.addContainerProperty("label", String.class, null);
			Item reload = clienteField.addItem("atualizar");
			reload.getItemProperty("label").setValue("--- Atualizar ---");
			clienteField.setItemCaptionPropertyId("label");
			clienteField.addValueChangeListener(new Property.ValueChangeListener() {
				@Override
				public void valueChange(Property.ValueChangeEvent event) {
					if (event.getProperty().getValue() != null
							&& event.getProperty().getValue().equals("atualizar")) {
											
						ComboBox currentCombo = (ComboBox) event.getProperty();					
						currentCombo.removeAllItems();

						Item reload = currentCombo.addItem("atualizar");
						reload.getItemProperty("label").setValue("--- Atualizar ---");

						carregaCombo(currentCombo);					
					}
				}
			});
			carregaCombo(clienteField);
			
			atendenteField = new TextField("Atendente");
			atendenteField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			atendenteField.setNullRepresentation("");
			atendenteField.setImmediate(true);
			atendenteField.setMaxLength(60);
			atendenteField.setRequired(true);
			atendenteField.setRequiredError(atendenteField.getCaption() + " obrigatório");
			
			dataField = new BaseDateField("Data de reserva", new Date(), false);
			dataField.setRequired(true);
			dataField.setRequiredError(dataField.getCaption() + " obrigatório");
			dataField.setWidth("156px");
			
			binder.bind(clienteField, "cliente");
			binder.bind(atendenteField, "atendente");
			if (item.getBean().getData() != null)
				dataField.setValue(item.getBean().getData().getTime());
			
			addComponent(clienteField);
			addComponent(atendenteField);
			addComponent(dataField);
		}
		
		@SuppressWarnings("unchecked")
		public void carregaCombo(ComboBox currentCombo) {
			try {
				ClienteService service = ServiceClient.getClienteService(ComprasUI.CLIENT_TYPE);
				List<Cliente> list = service.findAll();
				for (Cliente obj : list) {						
					Item i = currentCombo.addItem(obj);
					i.getItemProperty("label").setValue(obj.getNome());
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		@Override
		public void save() {
			try {
				if (binder.isValid()) {
					binder.commit();
					Calendar cal = new GregorianCalendar();
					cal.setTime(dataField.getValue());
					item.getBean().setData(cal);
					System.out.println(item.getBean().getData().getTime());
					System.out.println(item.getBean().getAtendente());
					System.out.println(item.getBean().getSituacao());
					System.out.println(item.getBean().getValor().doubleValue());
					System.out.println(item.getBean().getCliente().getId());
					ObjectMapper map = new ObjectMapper();
					System.out.println(map.writeValueAsString(item.getBean()));
					
					ReservaService service = ServiceClient.getReservaService(ComprasUI.CLIENT_TYPE);
					Reserva reserva = service.save(item.getBean());
					container.addItem(reserva);
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
