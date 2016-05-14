package br.com.erp.facade.funcionario;

import java.util.List;

import br.com.erp.entidade.Funcionario;
import br.com.erp.funcionario.controle.FuncionarioControleImpl;
import br.com.erp.funcionario.vo.FuncionarioVO;

public class CRMFacade {

	protected FuncionarioControleImpl funcionarioControle = new FuncionarioControleImpl();
	
	public CRMFacade() {
		
	}
	
	public void salvarFuncionario(FuncionarioVO vo){
		funcionarioControle.setFuncionarioVO(vo);
		funcionarioControle.salvarFuncionario();
	}
	
	public List<Funcionario> listarTodosFuncionarios(){
		return funcionarioControle.listaTodosFuncionarios();
	}
	
	public void deletarFuncionario(FuncionarioVO vo){
		funcionarioControle.setFuncionarioVO(vo);
		funcionarioControle.deletarFuncionario();
	}
}
