package br.com.compras.online.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class TestView extends BaseView {
	private final VerticalLayout verticalLayout = new VerticalLayout();

	public TestView() {
		buildView();
		addTab(verticalLayout, "Test", false);
	}

	public void buildView() {
		verticalLayout.addComponent(new Label("Olá mundo!"));
	}
}
