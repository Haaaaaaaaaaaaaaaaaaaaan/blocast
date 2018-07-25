package com.bc.frame;

import java.util.ArrayList;

public interface ADao<T,V> {
	public ArrayList<T> selectqid(V v) throws Exception;
}
