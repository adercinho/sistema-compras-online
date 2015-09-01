package br.com.compras.online.config;

import javax.servlet.annotation.WebServlet;

import br.com.compras.online.main.ComprasUI;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = ComprasUI.class)
public class ComprasVaadinServlet extends VaadinServlet {

}
