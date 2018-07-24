package com.bc.frame;

import java.util.ArrayList;

import com.bc.vo.UsersVO;

public interface Service<T,V> {
	public void register(T t) throws Exception;
	public void register(String v) throws Exception;
	public void modify(T t) throws Exception;
	public void remove(V v) throws Exception;
	public T get(V v) throws Exception;
	public ArrayList<T> get() throws Exception;
 }
