package br.com.compras.online.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.themes.ValoTheme;

public abstract class BaseView extends Panel implements View {
	final private TabSheet tabsheet = new TabSheet();
	
	public BaseView() {		
		Responsive.makeResponsive(this);
		setImmediate(true);
		setSizeFull();
		setStyleName(ValoTheme.PANEL_BORDERLESS);
		
		tabsheet.setSizeFull();
		tabsheet.addStyleName(ValoTheme.TABSHEET_EQUAL_WIDTH_TABS);
		setContent(tabsheet);
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
