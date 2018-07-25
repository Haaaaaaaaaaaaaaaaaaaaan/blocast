package com.bc.dao.mapper;

import java.util.ArrayList;

import com.bc.vo.AnswerVO;

public interface AnswerMapper {
	public void insert(AnswerVO obj);
	public void delete(String obj);
	public void update(AnswerVO obj);
	public AnswerVO select(String obj);
	public AnswerVO selectauthor(String obj);
	public ArrayList<AnswerVO> selectqid(String obj);
	public ArrayList<AnswerVO> selectall();
}
