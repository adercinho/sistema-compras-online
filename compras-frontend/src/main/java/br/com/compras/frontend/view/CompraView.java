package br.com.compras.frontend.view;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.entity.Compra;
import br.com.compras.backend.entity.Reserva;
import br.com.compras.frontend.client.ServiceClient;
import br.com.compras.frontend.client.services.CompraService;
import br.com.compras.frontend.client.services.ReservaService;
import br.com.compras.frontend.main.ComprasUI;
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
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class CompraView extends BaseView {
	private final VerticalLayout verticalLayout = new VerticalLayout();
	private final TableContainer container = new TableContainer();

	public CompraView() {
		buildView();
		addTab(verticalLayout, "Compra", false);
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
		table.setVisibleColumns("numero", "situacao", "data", "responsavel", "valor");
		table.setColumnHeaders("Número", "Situação", "Data", "Responsável", "Valor");
		
		table.addGeneratedColumn("action", new TableColumnGenerator());
		table.setColumnHeader("action", "Ações");
		
		return table;
	}
	

	@Override
	public void incluir() {
		DefaultWindow.open(new IncluirWindow(), "Nova compra", null, null);
	}

	@Override
	public void buscar() {
		CompraService service = ServiceClient.getCompraService(ComprasUI.CLIENT_TYPE);
		Compra compra = service.findById(Long.parseLong(getTxtId().getValue()));
		container.populate(compra);
	}

	@Override
	public void atualizar() {
		getTxtId().setValue(null);
		container.populate();
	}
	
	class TableContainer extends BeanItemContainer<Compra> {

		public TableContainer()
				throws IllegalArgumentException {
			super(Compra.class);
			populate();
		}
		
		public void populate() {
			try {
				removeAllItems();
				CompraService service = ServiceClient.getCompraService(ComprasUI.CLIENT_TYPE);
				populate(service.findAll());
			} catch (Exception e) {
				Message.ERROR.show("Erro ao buscar os dados. Detalhes: " + e.getMessage());
			}
		}
		
		public void populate(List<Compra> compraList) {
			removeAllItems();
			addAll(compraList);
		}
		
		public void populate(Compra compra) {
			removeAllItems();
			if (compra != null)
				addItem(compra);
		}
	}
	
	class TableColumnGenerator implements ColumnGenerator {
		public TableColumnGenerator() {}
		@Override
		public Object generateCell(Table source, Object itemId, Object columnId) {
			final Compra compra = (Compra) itemId;
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
							CompraService service = ServiceClient.getCompraService(ComprasUI.CLIENT_TYPE);
							service.delete(compra.getNumero());
							container.removeItem(compra);
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
		private final BeanItem<Compra> item;
		private TextField numeroField;
		private ComboBox reservaField;
		private TextField responsavelField;
		private TextField valorField;
		
		public IncluirWindow() {
			item = new BeanItem<Compra>(new Compra());
			binder = new FieldGroup(item);
			buildForm();
		}
		
		@SuppressWarnings("unchecked")
		private void buildForm() {
			numeroField = new TextField("Número");
			numeroField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			numeroField.setNullRepresentation("");
			numeroField.setImmediate(true);
			numeroField.setConverter(Long.class);
			numeroField.setMaxLength(60);
			numeroField.setRequired(true);
			numeroField.setRequiredError(numeroField.getCaption() + " obrigatório");
			
			reservaField = new ComboBox("Reserva");
			reservaField.setStyleName(ValoTheme.COMBOBOX_SMALL);
			reservaField.setImmediate(true);
			reservaField.setRequired(true);
			reservaField.setRequiredError(reservaField.getCaption() + " é obrigatório");
			reservaField.setNullSelectionAllowed(false);
			reservaField.setFilteringMode(FilteringMode.CONTAINS);
			reservaField.addContainerProperty("label", String.class, null);
			Item reload = reservaField.addItem("atualizar");
			reload.getItemProperty("label").setValue("--- Atualizar ---");
			reservaField.setItemCaptionPropertyId("label");
			reservaField.addValueChangeListener(new Property.ValueChangeListener() {
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
			carregaCombo(reservaField);
			
			responsavelField = new TextField("Responsavel");
			responsavelField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			responsavelField.setNullRepresentation("");
			responsavelField.setImmediate(true);
			responsavelField.setMaxLength(60);
			responsavelField.setRequired(true);
			responsavelField.setRequiredError(responsavelField.getCaption() + " obrigatório");
			
			valorField = new TextField("Valor");
			valorField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			valorField.setNullRepresentation("");
			valorField.setImmediate(true);
			valorField.setMaxLength(60);
			valorField.setConverter(BigDecimal.class);
			valorField.setRequired(true);
			valorField.setRequiredError(valorField.getCaption() + " é obrigatório");
			
			
			binder.bind(numeroField, "numero");
			binder.bind(reservaField, "reserva");
			binder.bind(responsavelField, "responsavel");
			binder.bind(valorField, "valor");
			
			addComponent(numeroField);
			addComponent(reservaField);
			addComponent(responsavelField);
			addComponent(valorField);
		}
		
		@SuppressWarnings("unchecked")
		public void carregaCombo(ComboBox currentCombo) {
			try {
				ReservaService service = ServiceClient.getReservaService(ComprasUI.CLIENT_TYPE);
				List<Reserva> list = service.findAll();
				for (Reserva obj : list) {						
					Item i = currentCombo.addItem(obj);
					i.getItemProperty("label").setValue(obj.getId() + " - " + new SimpleDateFormat("d/M/yy").format(obj.getData().getTime()));
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
					if (item.getBean().getReserva().getValor() != null)
						item.getBean().getReserva().getValor().add(item.getBean().getValor());
					
					CompraService service = ServiceClient.getCompraService(ComprasUI.CLIENT_TYPE);
					Compra compra = service.save(item.getBean());
					
					container.addItem(compra);
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
