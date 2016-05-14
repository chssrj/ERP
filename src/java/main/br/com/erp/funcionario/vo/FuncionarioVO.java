package br.com.erp.funcionario.vo;

import br.com.erp.entidade.Funcionario;
import br.com.infra.VO.VOImpl;

public class FuncionarioVO extends VOImpl<Funcionario> {

	private Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
