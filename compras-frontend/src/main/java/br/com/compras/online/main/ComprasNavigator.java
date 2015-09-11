package br.com.compras.online.main;

import br.com.compras.online.main.menu.ViewType;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

public class ComprasNavigator extends Navigator {
	private static final ViewType ERROR_VIEW = ViewType.CLIENTE;
	private ViewProvider errorViewProvider;
	
	public ComprasNavigator(final ComponentContainer container) {
		super(UI.getCurrent(), container);
		
		initViewChangeListener();
		initViewProviders();
	}

	private void initViewChangeListener() {
		addViewChangeListener(new ViewChangeListener() {
			@Override
			public boolean beforeViewChange(final ViewChangeEvent event) {
				System.out.println("Entrando na view: " + event.getViewName());
				return true;
			}

			@Override
			public void afterViewChange(final ViewChangeEvent event) {
				System.out.println("View atual: " + event.getViewName());
			}
		});
	}
	
	private void initViewProviders() {
		// A dedicated view provider is added for each separate view type
		for (final ViewType viewType : ViewType.values()) {
			ViewProvider viewProvider = new ClassBasedViewProvider(
					viewType.name(), viewType.getViewClass()) {
				private View cachedInstance;

				@Override
				public View getView(final String viewName) {
					View result = null;
					if (viewType.name().equals(viewName)) {
						if (viewType.isStateful()) {
							if (cachedInstance == null) {
								cachedInstance = super.getView(viewType.name());
							}
							result = cachedInstance;
						} else {
	                		result = super.getView(viewType.name());
						}
					}
					return result;
				}
			};

			if (viewType == ERROR_VIEW) {
				errorViewProvider = viewProvider;
			}

			addProvider(viewProvider);
		}

		setErrorProvider(new ViewProvider() {
			private static final long serialVersionUID = -6844728653127486145L;

			@Override
			public String getViewName(final String viewAndParameters) {
				return ERROR_VIEW.name();
			}

			@Override
			public View getView(final String viewName) {
				return errorViewProvider.getView(ERROR_VIEW.name());
			}
		});
	}
}
