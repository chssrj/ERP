package br.com.erp.funcionario.dao;

import java.sql.SQLException;

import br.com.erp.entidade.Funcionario;
import br.com.infra.dao.DAOGenerico;

public class FuncionarioDAOImpl extends DAOGenerico<Funcionario> implements FuncionarioDAO {

	public void salvarEntidade(Funcionario funcionario) throws SQLException {
		salvar(funcionario);
	}
	

}
