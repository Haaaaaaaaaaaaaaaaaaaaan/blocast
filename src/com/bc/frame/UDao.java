package com.bc.frame;

import com.bc.vo.UsersVO;

public interface UDao<T,V> {
	public void insertUser(V v, T t) throws Exception; 
	public UsersVO selectSearch(String v) throws Exception;
}
