package br.com.compras.online.main.menu;

import java.util.Iterator;

import br.com.compras.online.client.ClientType;
import br.com.compras.online.main.ComprasUI;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

public final class Menu extends CustomComponent {
	private final CssLayout menuItemsLayout = new CssLayout();
	public static final String ID = "menu";
	private static final String STYLE_VISIBLE = "valo-menu-visible";

	public Menu() {
		addStyleName("valo-menu");
		setId(ID);
		setSizeUndefined();

		setCompositionRoot(buildContent());
	}

	private Component buildContent() {
		final CssLayout menuContent = new CssLayout();
		menuContent.addStyleName("sidebar");
		menuContent.addStyleName(ValoTheme.MENU_PART);
		menuContent.addStyleName("no-vertical-drag-hints");
		menuContent.addStyleName("no-horizontal-drag-hints");
		menuContent.setWidth(null);
		menuContent.setHeight("100%");
		menuContent.addComponent(buildTitle());
		menuContent.addComponent(buildSwitcher());
		menuContent.addComponent(buildToggleButton());
		menuContent.addComponent(buildMenuItems());

		return menuContent;
	}
	
	private Component buildTitle() {
		Label logo = new Label("Compras <strong>Online</strong>",
				ContentMode.HTML);
		logo.setSizeUndefined();
		HorizontalLayout logoWrapper = new HorizontalLayout(logo);
		logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
		logoWrapper.addStyleName("valo-menu-title");
		return logoWrapper;
	}

	private Component buildSwitcher() {
		OptionGroup sample = new OptionGroup();
		sample.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);
        for (ClientType clientType : ClientType.values()) {
            sample.addItem(clientType);
            sample.setItemCaption(clientType, clientType.toString());
        }
        sample.select(ComprasUI.CLIENT_TYPE);
        sample.setNullSelectionAllowed(false);
        sample.setImmediate(true);
        sample.addValueChangeListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				ComprasUI.CLIENT_TYPE = (ClientType) event.getProperty().getValue();
			}
		});
        
		return sample;
	}

	private Component buildToggleButton() {
		Button valoMenuToggleButton = new Button("Menu", new ClickListener() {
			@Override
			public void buttonClick(final ClickEvent event) {
				if (getCompositionRoot().getStyleName().contains(STYLE_VISIBLE)) {
					getCompositionRoot().removeStyleName(STYLE_VISIBLE);
				} else {
					getCompositionRoot().addStyleName(STYLE_VISIBLE);
				}
			}
		});
		valoMenuToggleButton.setIcon(FontAwesome.LIST);
		valoMenuToggleButton.addStyleName("valo-menu-toggle");
		valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);
		return valoMenuToggleButton;
	}

	private Component buildMenuItems() {
		menuItemsLayout.addStyleName("valo-menuitems");
		menuItemsLayout.setHeight(100.0f, Unit.PERCENTAGE);
		for (final ViewType view : ViewType.values()) {
			menuItemsLayout.addComponent(new ValoMenuItemButton(view));
		}
		return menuItemsLayout;
	}

	public final class ValoMenuItemButton extends Button {
		private static final String STYLE_SELECTED = "selected";
		public ValoMenuItemButton(final ViewType view) {
			setPrimaryStyleName("valo-menu-item");
			setIcon(view.getIcon());
			setCaption(view.toString().substring(0, 1).toUpperCase()
					+ view.toString().substring(1));
			addClickListener(new ClickListener() {
				@Override
				public void buttonClick(final ClickEvent event) {
					UI.getCurrent().getNavigator().navigateTo(view.name());
					for (Iterator<Component> iter = menuItemsLayout.iterator(); iter.hasNext();) {
						Component c = iter.next();
						c.removeStyleName(STYLE_SELECTED);
					}
					event.getButton().addStyleName(STYLE_SELECTED);
				}
			});
		}
	}
}
