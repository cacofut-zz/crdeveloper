package br.com.crdeveloper.dao;

import java.util.List;

public interface DAO<T> {
	
	T salvar(T objeto);
	int deletar(int id);
	List<T> listarTodos();
	List<T> listarId(int id);
	T alterar(T objeto);
	
}
