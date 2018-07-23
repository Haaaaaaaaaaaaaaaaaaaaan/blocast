package com.bc.frame;

public interface UService<T,V> {
	public void registerUser(V v, T t) throws Exception;
}
