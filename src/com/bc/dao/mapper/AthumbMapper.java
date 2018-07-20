package com.bc.dao.mapper;

import java.util.ArrayList;

import com.bc.vo.AnswerThumbsupVO;


public interface AthumbMapper {
	public void insert(AnswerThumbsupVO obj);
	public void delete(String obj);
	public void update(AnswerThumbsupVO obj);
	public AnswerThumbsupVO select(String obj);
	public ArrayList<AnswerThumbsupVO> selectall();
}
