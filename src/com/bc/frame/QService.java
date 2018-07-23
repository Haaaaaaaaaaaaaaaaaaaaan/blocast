package com.bc.frame;

import java.util.ArrayList;

public interface QService<T,V> {
	public ArrayList<T> getNameCont(String v) throws Exception;
	public ArrayList<T> getAuthor(String v) throws Exception;
	public ArrayList<T> getClassid(String v) throws Exception;
}
