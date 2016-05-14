package br.com.erp.teste.funcionario;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

import br.com.erp.entidade.Funcionario;

public class TestDAO {

	protected EntityManagerFactory factory;
	
	@Test
	public void init(){
		iniciarConexaoComABase();
	}
	
	public void iniciarConexaoComABase(){
		factory = Persistence.createEntityManagerFactory("erp");
		Assert.assertNotNull(factory);
	}
	
	public void salvarObjetoNaBase(){
		EntityManager manager = factory.createEntityManager();
		Assert.assertNotNull(manager);
		
		Calendar calendar = Calendar.getInstance();
		Funcionario funcionario = new Funcionario();
		funcionario.setDataNascimento(calendar);
		funcionario.setNome("Matheus");
		
		Assert.assertEquals("A data de nascimento est� incorreta",calendar, funcionario.getDataNascimento());
		Assert.assertEquals("O nome do funcion�rio est� incorreto","Matheus", funcionario.getNome());
		
		manager.getTransaction().begin();
		manager.persist(funcionario);
		manager.getTransaction().commit();
		
		Assert.assertNotNull("O registro de funcion�rio n�o foi inserido",funcionario.getId());
		System.out.println("Funcion�rio salvo com o id : "+funcionario.getId());
		
		manager.close();
	}
}
