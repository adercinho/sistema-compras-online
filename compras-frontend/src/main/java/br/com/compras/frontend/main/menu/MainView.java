package br.com.compras.frontend.main.menu;

import br.com.compras.frontend.main.ComprasNavigator;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

public class MainView extends HorizontalLayout {
	public MainView() {
        setSizeFull();
        addComponent(new Menu());

        ComponentContainer content = new CssLayout();
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);

        new ComprasNavigator(content);
    }
}
