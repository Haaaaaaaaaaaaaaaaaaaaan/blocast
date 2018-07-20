package com.bc.dao.mapper;

import java.util.ArrayList;

import com.bc.vo.QuestionThumbsupVO;


public interface QthumbMapper {
	public void insert(QuestionThumbsupVO obj);
	public void delete(String obj);
	public void update(QuestionThumbsupVO obj);
	public QuestionThumbsupVO select(String obj);
	public ArrayList<QuestionThumbsupVO> selectall();
}
