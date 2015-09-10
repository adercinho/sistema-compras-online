package br.com.compras.online.client;

import java.util.List;

public interface ServiceLocator<T> {

	T findById(Long id);
	List<T> findAll();
	T save(T entity);
	void delete(Long id);
}
