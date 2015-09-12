package br.com.compras.frontend.view;

import java.math.BigDecimal;
import java.util.List;

import br.com.compras.backend.entity.Produto;
import br.com.compras.frontend.client.ServiceClient;
import br.com.compras.frontend.client.services.ProdutoService;
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

public class ProdutoView extends BaseView {
	private final VerticalLayout verticalLayout = new VerticalLayout();
	private final TableContainer container = new TableContainer();

	public ProdutoView() {
		buildView();
		addTab(verticalLayout, "Produto", false);
	}

	public void buildView() {
		verticalLayout.setMargin(true);
		verticalLayout.setSpacing(true);
		verticalLayout.addComponent(buildHeader());
		verticalLayout.addComponent(buildTable());
	}
	
	public Component buildHeader() {
		Component header = super.buildHeader();
		
		Button exibir = new Button("Exibir produtos com pre�o menor que mil reais");
		exibir.setImmediate(true);
		exibir.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				ProdutoService service = ServiceClient.getProdutoService(ComprasUI.CLIENT_TYPE);
				container.populate(service.findProdutosMenorQueMilReais());
			}
		});
		getHeader().addComponent(exibir);
		
		return header;
	}
	
	private Component buildTable() {
		Table table = new Table();
		table.setContainerDataSource(container);
		table.setSizeFull();
		table.setVisibleColumns("codigo", "descricao", "preco", "estoque");
		table.setColumnHeaders("C�digo", "Descri��o", "Pre�o", "Estoque");
		
		table.addGeneratedColumn("action", new TableColumnGenerator());
		table.setColumnHeader("action", "A��es");
		
		return table;
	}
	

	@Override
	public void incluir() {
		DefaultWindow.open(new IncluirWindow(), "Novo produto", null, null);
	}

	@Override
	public void buscar() {
		ProdutoService service = ServiceClient.getProdutoService(ComprasUI.CLIENT_TYPE);
		Produto produto = service.findById(Long.parseLong(getTxtId().getValue()));
		container.populate(produto);
	}

	@Override
	public void atualizar() {
		getTxtId().setValue(null);
		container.populate();
	}
	
	class TableContainer extends BeanItemContainer<Produto> {

		public TableContainer()
				throws IllegalArgumentException {
			super(Produto.class);
			populate();
		}
		
		public void populate() {
			try {
				removeAllItems();
				ProdutoService service = ServiceClient.getProdutoService(ComprasUI.CLIENT_TYPE);
				populate(service.findAll());
			} catch (Exception e) {
				Message.ERROR.show("Erro ao buscar os dados. Detalhes: " + e.getMessage());
			}
		}
		
		public void populate(List<Produto> produtoList) {
			removeAllItems();
			addAll(produtoList);
		}
		
		public void populate(Produto produto) {
			removeAllItems();
			if (produto != null)
				addItem(produto);
		}
	}
	
	class TableColumnGenerator implements ColumnGenerator {
		public TableColumnGenerator() {}
		@Override
		public Object generateCell(Table source, Object itemId, Object columnId) {
			final Produto produto = (Produto) itemId;
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
//							if (produto.getReservaList().isEmpty()) {
								ProdutoService service = ServiceClient.getProdutoService(ComprasUI.CLIENT_TYPE);
								service.delete(produto.getCodigo());
								container.removeItem(produto);
								Message.DELETE_SUCCESS.show();
//							} else {
//								Message.ALERT.show("o produto " + produto.getNome() + " possui reservas efetuadas, "
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
		private final BeanItem<Produto> item;
		private TextField descricaoField;
		private TextField precoField;
		private TextField estoqueField;
		
		public IncluirWindow() {
			item = new BeanItem<Produto>(new Produto());
			binder = new FieldGroup(item);
			buildForm();
		}
		
		private void buildForm() {
			descricaoField = new TextField("Descri��o");
			descricaoField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			descricaoField.setNullRepresentation("");
			descricaoField.setImmediate(true);
			descricaoField.setMaxLength(60);
			descricaoField.setRequired(true);
			descricaoField.setRequiredError(descricaoField.getCaption() + " � obrigat�rio");
			
			precoField = new TextField("Pre�o");
			precoField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			precoField.setNullRepresentation("");
			precoField.setImmediate(true);
			precoField.setMaxLength(60);
			precoField.setConverter(BigDecimal.class);
			precoField.setRequired(true);
			precoField.setRequiredError(precoField.getCaption() + " � obrigat�rio");
			
			estoqueField = new TextField("Estoque");
			estoqueField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
			estoqueField.setStyleName(ValoTheme.TEXTFIELD_ALIGN_RIGHT);
			estoqueField.setNullRepresentation("");
			estoqueField.setImmediate(true);
			estoqueField.setMaxLength(11);
			estoqueField.setRequired(true);
			estoqueField.setRequiredError(estoqueField.getCaption() + " � obrigat�rio");
			
			binder.bind(descricaoField, "descricao");
			binder.bind(precoField, "preco");
			binder.bind(estoqueField, "estoque");
			
			addComponent(descricaoField);
			addComponent(precoField);
			addComponent(estoqueField);
		}

		@Override
		public void save() {
			try {
				if (binder.isValid()) {
					binder.commit();
					ProdutoService service = ServiceClient.getProdutoService(ComprasUI.CLIENT_TYPE);
					Produto produto = service.save(item.getBean());
					container.addItem(produto);
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
