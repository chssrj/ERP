package br.com.erp.funcionario.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.erp.entidade.Funcionario;
import br.com.erp.funcionario.dao.FuncionarioDAO;
import br.com.erp.funcionario.dao.FuncionarioDAOImpl;
import br.com.erp.funcionario.vo.FuncionarioVO;
import br.com.infra.VO.VOImpl;
import br.com.infra.controle.ControleGenerico;
import br.com.infra.dao.DAO;

public class FuncionarioControleImpl extends ControleGenerico<Funcionario, FuncionarioDAO> implements FuncionarioControle {

	private FuncionarioDAO dao = new FuncionarioDAOImpl();
	private FuncionarioVO funcionarioVO = new FuncionarioVO();
	
	@Override
	public VOImpl<Funcionario> getVO() {
		return funcionarioVO;
	}
	
	public void salvarFuncionario() {
		try {
			Funcionario funcionario = getVO().getEntidade();
			dao.salvarEntidade(funcionario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarFuncionario() {
		deletar(getVO().getEntidade());
	}

	public List<Funcionario> listaTodosFuncionarios() {
		return dao.obterTodos();
	}

	public void setFuncionarioVO(FuncionarioVO funcionarioVO) {
		this.funcionarioVO = funcionarioVO;
	}

	@Override
	public DAO<Funcionario> getDAO() {
		return new FuncionarioDAOImpl();
	}
	
	

	
}
