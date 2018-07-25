package com.bc.frame;

import java.util.ArrayList;

import com.bc.vo.ClassVO;

public interface AService<T,V> {
	public ArrayList<T> getqid(V v) throws Exception;
}
