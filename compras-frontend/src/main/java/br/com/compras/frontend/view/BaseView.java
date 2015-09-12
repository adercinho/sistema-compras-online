package br.com.compras.frontend.view;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public abstract class BaseView extends Panel implements View {
	final private TabSheet tabsheet = new TabSheet();
	final private TextField txtId = new TextField();
	final private HorizontalLayout h1 = new HorizontalLayout();
	
	public BaseView() {		
		Responsive.makeResponsive(this);
		setImmediate(true);
		setSizeFull();
		setStyleName(ValoTheme.PANEL_BORDERLESS);
		
		tabsheet.setSizeFull();
		tabsheet.addStyleName(ValoTheme.TABSHEET_EQUAL_WIDTH_TABS);
		setContent(tabsheet);
	}
	
	public Component buildHeader() {
		VerticalLayout header = new VerticalLayout();
		header.addStyleName(ValoTheme.WINDOW_TOP_TOOLBAR);
		
		h1.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
		h1.setSpacing(true);
		Button incluir = new Button("Incluir", FontAwesome.STAR);
		incluir.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		incluir.setImmediate(true);
		incluir.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				incluir();
			}
		});
		
		CssLayout h2 = new CssLayout();
		h2.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		
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
					buscar();
				}
			}
		});
		
		Button atualizar = new Button("Atualizar" ,FontAwesome.REFRESH);
		atualizar.setImmediate(true);
		atualizar.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				atualizar();
			}
		});
		
		h2.addComponent(txtId);
		h2.addComponent(buscar);
		
		h1.addComponent(incluir);
		h1.addComponent(h2);
		h1.addComponent(atualizar);
		
		header.addComponent(h1);
		
		return header;
	}
	
	public abstract void incluir();
	public abstract void buscar();
	public abstract void atualizar();
	
	public HorizontalLayout getHeader() {
		return h1;
	}
	
	public TextField getTxtId() {
		return txtId;
	}
	
	public void addTab(Component c, String caption) {
		addTab(c, caption, true);
	}
	
	public void addTab(Component c, String caption, boolean closable) {
		for (int i = 0; i < tabsheet.getComponentCount(); i++) {
			if (tabsheet.getTab(i).getCaption().equals(caption)) {
				tabsheet.setSelectedTab(i);
				return;
			}
		}
		tabsheet.addTab(c, caption);
		tabsheet.getTab(c).setClosable(closable);
		tabsheet.setSelectedTab(c);
	}
	
	public void removeTab(Component c) {
		tabsheet.removeTab(tabsheet.getTab(c));
	}
	
	@Override
	public void enter(ViewChangeEvent event) {}
}
