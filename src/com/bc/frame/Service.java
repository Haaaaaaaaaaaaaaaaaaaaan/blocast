package com.bc.frame;

import java.util.ArrayList;

import com.bc.vo.UsersVO;

public interface Service<T,V> {
	public void register(T t) throws Exception;
	public void registerUser(V v, T t) throws Exception;
	public void modify(T t) throws Exception;
	public void remove(V v) throws Exception;
	public T get(V v) throws Exception;
	public ArrayList<T> getQid(String v) throws Exception;
	public ArrayList<T> getTid(String v) throws Exception;
	public ArrayList<T> get() throws Exception;
	public ArrayList<T> getName(String v) throws Exception;
	public ArrayList<T> getNameCont(String v) throws Exception;
	public ArrayList<T> getAuthor(String v) throws Exception;
	public UsersVO getSearch(String v) throws Exception;
 }
