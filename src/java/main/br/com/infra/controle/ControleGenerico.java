package br.com.infra.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.infra.VO.VOImpl;
import br.com.infra.dao.DAO;

public abstract class ControleGenerico<T , E extends DAO<T>> implements Controle<T> {

	public abstract DAO<T> getDAO();
	
	public void salvar(T entidade) throws SQLException {
		getDAO().salvar(entidade);
	}

	public List<T> obterTodos() {
		return getDAO().obterTodos();
	}

	public void deletar(T entidade) {
		getDAO().deletar(entidade);
	}

	public void deletarTodos() {
		getDAO().deletarTodos();
	}
	
	public abstract VOImpl<T> getVO();

}
