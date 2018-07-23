package com.bc.frame;

import java.util.ArrayList;

import com.bc.vo.TagVO;

public interface TDao<T,V> {
	
	public ArrayList<T> selectname(String v) throws Exception;
	public T selectrecent() throws Exception;
}
