package br.com.infra.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

	public void salvar(T entidade) throws SQLException;
	
	public List<T> obterTodos();
	
	public void deletar(T entidade);
	
	public void deletarTodos();
	
	
}
