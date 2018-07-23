package com.bc.frame;

import java.util.ArrayList;

import com.bc.vo.QuestionVO;
import com.bc.vo.UsersVO;

public interface Dao<T,V> {
	public void insert(T t) throws Exception; 
	//com.bc.frame.TagDao
	public void insert(String obj) throws Exception; 
	public void update(T t) throws Exception;
	public void delete(V v) throws Exception;
	public T select(V v) throws Exception;
	public ArrayList<T> selectall() throws Exception;
	
	
}
