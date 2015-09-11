package br.com.compras.online.utils;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.ValoTheme;

public enum Message {
	ERROR (Type.ERROR_MESSAGE, FontAwesome.WARNING, ""),
	ALERT (Type.WARNING_MESSAGE, FontAwesome.EXCLAMATION, ""),
	SUCCESS (Type.HUMANIZED_MESSAGE, FontAwesome.CHECK, ""),
	SAVE_SUCCESS (Type.HUMANIZED_MESSAGE, FontAwesome.CHECK, "Salvo com sucesso!"),
	SAVE_ERROR (Type.ERROR_MESSAGE, FontAwesome.WARNING, "Erro ao salvar!"),
	DELETE_SUCCESS (Type.HUMANIZED_MESSAGE, FontAwesome.CHECK, "Excluido com sucesso!"),
	DELETE_ERROR (Type.ERROR_MESSAGE, FontAwesome.WARNING, "Erro ao excluir!");

	private final String mensagem;
	private final Type type;
	private final Resource icon;

	private Message(Type type, Resource icon, String mensagem) {
		this.mensagem = mensagem;
		this.type = type;
		this.icon = icon;
	}

	public void show() {
		show(mensagem);
	}
	
	public void show(String msg){
		show(msg, 1000);
	}

	public void show(String msg, int delayMsec){
		Notification notification = new Notification("", msg, type);
		notification.setPosition(Position.TOP_CENTER);
		notification.setStyleName(ValoTheme.NOTIFICATION_BAR + " " + type.getStyle());
		notification.setDelayMsec(delayMsec);
		notification.setIcon(icon);
		notification.show(Page.getCurrent());
	}
}
