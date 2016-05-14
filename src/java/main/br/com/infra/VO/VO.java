package br.com.infra.VO;

import java.io.Serializable;

public interface VO<E> extends Serializable {

	public E getVO();
}
