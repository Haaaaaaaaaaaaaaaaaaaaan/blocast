package com.bc.frame;

import java.util.ArrayList;

public interface TlService<T,V> {
	public ArrayList<T> getQid(String v) throws Exception;
	public ArrayList<T> getTid(String v) throws Exception;
}
