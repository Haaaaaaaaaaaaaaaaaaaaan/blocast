package com.bc.frame;

import java.util.ArrayList;

public interface TService<T,V> {
	public ArrayList<T> getName(String v) throws Exception;
}
