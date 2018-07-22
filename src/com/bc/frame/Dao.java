package com.bc.frame;

import java.util.ArrayList;

import com.bc.vo.UsersVO;

public interface Dao<T,V> {
	public void insert(T t) throws Exception; 
	public void insertUser(V v, T t) throws Exception; 
	public void update(T t) throws Exception;
	public void delete(V v) throws Exception;
	public T select(V v) throws Exception;
	public ArrayList<T> selectall() throws Exception;
	public UsersVO selectSearch(String v) throws Exception;
}
