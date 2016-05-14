package br.com.infra.VO;

public abstract class VOImpl<E> {

	private E entidade;

	public E getEntidade() {
		return entidade;
	}

	public void setEntidade(E entidade) {
		this.entidade = entidade;
	}
	
	
}
