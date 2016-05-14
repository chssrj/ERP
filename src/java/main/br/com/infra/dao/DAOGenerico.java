package br.com.infra.dao;

import java.sql.SQLException;
import java.util.List;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public abstract class DAOGenerico<T> implements DAO<T>  {

	private EntityManager manager;
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public DAOGenerico() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private void initFactory(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("erp");
		manager = factory.createEntityManager();
	}

	public void salvar(T entidade) throws SQLException{

		try{
			getConexao().getTransaction().begin();
			getConexao().persist(entidade);
		}catch(Exception e){
			getConexao().getTransaction().rollback();
			getConexao().close();
			throw new SQLException("Ocorreu um erro ao tentar inserir entidade");
		}

		getConexao().getTransaction().commit();

	}

	public void deletar(T entidade) {
		getConexao().getTransaction().begin();
		getConexao().remove(entidade);
		getConexao().getTransaction().commit();
	}
	
	public void deletarTodos(){
		getConexao().getTransaction().begin();
		getConexao().createQuery("delete from "+persistentClass.getSimpleName()).executeUpdate();
		getConexao().getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> obterTodos(){
		List resultList = getConexao().createQuery("select e from "+ persistentClass.getSimpleName() + " e").getResultList();
		return resultList;
	}

	public EntityManager getConexao() {
		if(manager == null){
			initFactory(); 
		}
		return manager;
	}

	public Session getSession(){
		return getConexao().unwrap(Session.class);
	}
}
