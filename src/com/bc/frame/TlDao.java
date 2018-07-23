package com.bc.frame;

import java.util.ArrayList;

public interface TlDao<T,V> {


	public ArrayList<T> selectqid(String obj);
	public ArrayList<T> selecttid(String obj);
}
