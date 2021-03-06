package br.com.compras.frontend.main.menu;

import br.com.compras.frontend.view.ClienteView;
import br.com.compras.frontend.view.CompraView;
import br.com.compras.frontend.view.ProdutoView;
import br.com.compras.frontend.view.ReservaView;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum ViewType implements Comparable<ViewType> {	
    CLIENTE(ClienteView.class, "Cliente", FontAwesome.USER, false),
    PRODUTO(ProdutoView.class, "Produto", FontAwesome.ANDROID, false),
    RESERVA(ReservaView.class, "Reserva", FontAwesome.IMAGE, false),
    COMPRA(CompraView.class, "Compra", FontAwesome.FLAG, false);

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;

	private ViewType(final Class<? extends View> viewClass, String viewName, final Resource icon, final boolean stateful) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }

    public boolean isStateful() {
        return stateful;
    }

    public Class<? extends View> getViewClass() {
    	return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }
    
    public static ViewType getByViewName(final String viewName) {
        ViewType result = null;
        for (ViewType viewType : values()) {
            if (viewType.toString().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

    public static ViewType getByEnumName(final String enumName) {
        ViewType result = null;
        for (ViewType viewType : values()) {
            if (viewType.name().equals(enumName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
    	return this.viewName;
    }
}
