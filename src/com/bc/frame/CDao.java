package com.bc.frame;

public interface CDao<T,V> {
	public T selectname(V v) throws Exception;
}
