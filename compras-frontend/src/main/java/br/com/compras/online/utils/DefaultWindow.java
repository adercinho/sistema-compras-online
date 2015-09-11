package br.com.compras.online.utils;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.Responsive;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class DefaultWindow extends Window {
	private static final long serialVersionUID = -7671876343295212613L;
	
	private TabSheet detailsWrapper;
	
	public DefaultWindow(BaseForm baseForm, String caption, Float height, Float width) {
		Responsive.makeResponsive(this);
		
		setModal(true);
		setCloseShortcut(KeyCode.ESCAPE, null);
		setResizable(false);
		setHeight(height == null ? 60.0f : height, Unit.PERCENTAGE);
		setWidth(width == null ? 70.0f : width, Unit.PERCENTAGE);
		
		detailsWrapper = new TabSheet();
		detailsWrapper.setSizeFull();
		detailsWrapper.addStyleName(ValoTheme.TABSHEET_EQUAL_WIDTH_TABS);		
		detailsWrapper.addTab(baseForm.getLayout(), caption);
		setContent(detailsWrapper);		
	}
	
	public static void open(BaseForm baseForm, String caption, Float height, Float width) {
		Window w = new DefaultWindow(baseForm, caption, height, width);
		baseForm.setWindow(w);
		UI.getCurrent().addWindow(w);
		w.focus();		
	}
}
