package br.com.compras.online.main;

import br.com.compras.online.client.ClientType;
import br.com.compras.online.main.menu.MainView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@Theme("compras")
@Title("Compras online")
public class ComprasUI extends UI {
	public static ClientType CLIENT_TYPE = ClientType.REST;
	
	@Override
	protected void init(VaadinRequest request) {
		Responsive.makeResponsive(this);
		addStyleName(ValoTheme.UI_WITH_MENU);
		setContent(new MainView());
		getNavigator().navigateTo(getNavigator().getState());
	}
}