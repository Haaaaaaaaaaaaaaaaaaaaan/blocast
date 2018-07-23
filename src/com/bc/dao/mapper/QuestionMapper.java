package com.bc.dao.mapper;

import java.util.ArrayList;

import com.bc.vo.QuestionVO;


public interface QuestionMapper {
	public void insert(QuestionVO obj);
	public void delete(String obj);
	public void update(QuestionVO obj);
	public QuestionVO select(String obj);
	public ArrayList<QuestionVO> selectnamecont(String obj);
	public ArrayList<QuestionVO> selectauthor(String obj);
	public ArrayList<QuestionVO> selectclass(String obj);
	public ArrayList<QuestionVO> selectall();
}
