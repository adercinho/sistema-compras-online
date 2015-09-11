package br.com.compras.online.utils;

import org.apache.log4j.Logger;

import br.com.compras.online.view.BaseView;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public abstract class BaseForm extends VerticalLayout {
	
	final private Panel panelLayout = new Panel();
	final private VerticalLayout formLayout = new VerticalLayout();
	final private VerticalLayout layout = new VerticalLayout();
	final protected HorizontalLayout footer = new HorizontalLayout();
	private BaseView view;
	private Window window;
	protected Button save;
	protected Button cancel;
	protected static Logger log = Logger.getLogger(BaseForm.class);
	
	public BaseForm() {
		Responsive.makeResponsive(layout);
		setSpacing(true);
		setImmediate(true);		
		setSizeFull();
		
		save = new Button("Salvar", new GeneralButtonClickListener());
		cancel = new Button("Cancelar", new GeneralButtonClickListener());

		save.addStyleName(ValoTheme.BUTTON_PRIMARY);
		save.addStyleName(ValoTheme.BUTTON_SMALL);
		save.setIcon(FontAwesome.SAVE);
		
		cancel.addStyleName(ValoTheme.BUTTON_SMALL);
		cancel.setIcon(FontAwesome.BAN);
		
		footer.setWidth(100.0f, Unit.PERCENTAGE);
		footer.setSpacing(true);
		footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
		
		Label label = new Label();
		footer.addComponent(label);
		footer.setExpandRatio(label, 1f);
		
		footer.addComponent(save);
		footer.addComponent(cancel);
		
		Panel content = new Panel();
		content.addStyleName(ValoTheme.PANEL_BORDERLESS);
		content.setSizeFull();
		
		formLayout.setImmediate(true);	
		formLayout.setWidth(100.0f, Unit.PERCENTAGE);
		formLayout.setMargin(true);
		formLayout.addComponent(this);
		
		content.setContent(formLayout);
		
		layout.addComponent(content);
		layout.setExpandRatio(content, 1f);
		layout.setSizeFull();
		layout.addComponent(footer);
		
		
		panelLayout.setSizeFull();
		panelLayout.addStyleName(ValoTheme.PANEL_SCROLL_INDICATOR);
		panelLayout.addStyleName(ValoTheme.PANEL_BORDERLESS);
		panelLayout.setContent(layout);
	}
	
	public Panel getLayout() {
		return panelLayout;
	}
	
	public BaseForm getForm() {
		return this;
	}
	
	public BaseView getView() {
		return this.view;
	}
	
	public void setView(BaseView view) {
		this.view = view;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public abstract void save();
	public abstract void cancel();
	
	class GeneralButtonClickListener implements ClickListener {
		private static final long serialVersionUID = -4807010887953707572L;

		@Override
		public void buttonClick(ClickEvent event) {
			if (event.getButton() == save) {
				save();
			} else if (event.getButton() == cancel) {
				cancel();
			}
		}
	}
}
