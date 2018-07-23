package com.bc.frame;

import java.util.ArrayList;

import com.bc.vo.QuestionVO;

public interface QDao<T,V> {
	public ArrayList<T> selectnamecont(String obj) throws Exception;
	public ArrayList<T> selectauthor(String obj) throws Exception;
}
