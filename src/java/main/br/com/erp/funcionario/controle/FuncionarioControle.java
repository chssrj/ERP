package br.com.erp.funcionario.controle;

import java.util.List;

import br.com.erp.entidade.Funcionario;
import br.com.infra.controle.Controle;

public interface FuncionarioControle extends Controle<Funcionario>{

	public void salvarFuncionario();
	
	public void deletarFuncionario();
	
	public List<Funcionario> listaTodosFuncionarios();
}
