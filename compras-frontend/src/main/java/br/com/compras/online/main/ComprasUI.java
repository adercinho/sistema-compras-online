package br.com.compras.online.main;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("compras")
@Title("Compras online")
public class ComprasUI extends UI {
	
	@Override
	protected void init(VaadinRequest request) {
		Responsive.makeResponsive(this);
		addStyleName(ValoTheme.UI_WITH_MENU);
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(new Button("Hello world") {{
			addClickListener(new ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					Notification notification = new Notification("Sucesso", "Funcionou caralho2", Type.HUMANIZED_MESSAGE);
					notification.setPosition(Position.TOP_CENTER);
					notification.setStyleName(ValoTheme.NOTIFICATION_BAR);
					notification.setDelayMsec(3000);
					notification.setIcon(FontAwesome.SUN_O);
					notification.show(Page.getCurrent());
				}
			});
		}});
		setContent(layout);
	}
}