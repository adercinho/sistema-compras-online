package br.com.compras.frontend.client.services;

import java.util.List;

public interface AbstractService<T> {

	T findById(Long id);
	List<T> findAll();
	T save(T entity);
	void delete(Long id);
}
