package br.com.erp.funcionario.dao;

import java.sql.SQLException;

import br.com.erp.entidade.Funcionario;
import br.com.infra.dao.DAO;

public interface FuncionarioDAO extends DAO<Funcionario> {
	
	public void salvarEntidade(Funcionario funcionario) throws SQLException;
}
