package br.com.erp.teste.funcionario;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.erp.entidade.Cargo;
import br.com.erp.entidade.Funcionario;
import br.com.erp.facade.funcionario.CRMFacade;
import br.com.erp.funcionario.controle.FuncionarioControle;
import br.com.erp.funcionario.controle.FuncionarioControleImpl;
import br.com.erp.funcionario.dao.FuncionarioDAO;
import br.com.erp.funcionario.dao.FuncionarioDAOImpl;
import br.com.erp.funcionario.vo.FuncionarioVO;

public class TestFuncionarioDAO extends Mockito {

	private FuncionarioDAO dao = new FuncionarioDAOImpl();
	private Funcionario funcionario = Mockito.mock(Funcionario.class);
	private FuncionarioVO vo = new FuncionarioVO();
	private CRMFacade facade = new CRMFacade();
	
	@Before
	public void criarEntidade(){
		funcionario = new Funcionario();
		Cargo cargo = new Cargo();
		cargo.setId(1L);
		funcionario.setDataNascimento(Calendar.getInstance());
		funcionario.setDataAdmissao(Calendar.getInstance());
		funcionario.setNome("Matheus Lubarino");
		funcionario.setCargo(cargo);
	}
	
	@Test
	public void init() throws SQLException{
		vo.setEntidade(funcionario);
		deletarTodosFuncionarios();
		salvarFuncionario();
		listarTodosFuncionarios();
//		salvarFuncionarioComCargo();
		listarTodosOsFuncionarioComCargo();
		deletarTodosFuncionarios();
		listarTodosFuncionariosDeletados();
	}
	
	public void salvarFuncionario() throws SQLException{
		facade.salvarFuncionario(vo);
	}
	
	public void listarTodosFuncionarios(){
		List<Funcionario> funcionarios = facade.listarTodosFuncionarios();
		Assert.assertNotNull("A lista de funcionário é nula",funcionarios);
		Assert.assertFalse("A lista de funcionário está vazia",funcionarios.size() <= 0);
	}
	
	public void deletaFuncionario(){
		facade.deletarFuncionario(vo);
	}
	
	public void deletarTodosFuncionarios(){
		dao.deletarTodos();
	}
	
	public void listarTodosFuncionariosDeletados(){
		List<Funcionario> funcionarios = facade.listarTodosFuncionarios();
		Assert.assertTrue("A lista de funcionário não está vazia depois de ter sido deletada",funcionarios.size() <= 0);
	}
	
	public void salvarFuncionarioComCargo() throws SQLException{
		Funcionario funcionario = new Funcionario();
		Cargo cargo = new Cargo();
		cargo.setId(1L);
		funcionario.setDataNascimento(Calendar.getInstance());
		funcionario.setDataAdmissao(Calendar.getInstance());
		funcionario.setNome("Matheus Lubarino");
		funcionario.setCargo(cargo);
		dao.salvar(funcionario);
	}
	
	public void listarTodosOsFuncionarioComCargo(){
		List<Funcionario> funcionarios = facade.listarTodosFuncionarios();
		Assert.assertNotNull("A lista de funcionário é nula",funcionarios);
		Assert.assertFalse("A lista de funcionário com cargo está vazia",funcionarios.size() <= 0);
		
		for (Funcionario funcionario : funcionarios) {
			Assert.assertNotNull("A descricação do cargo é nula",funcionario.getCargo());
			Assert.assertFalse("A descrição do cargo está vazia",funcionario.getCargo().getDescricao().trim().isEmpty());
		}
	}
	
}
