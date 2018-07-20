package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.bc.dao.mapper.QthumbMapper;
import com.bc.frame.Dao;
import com.bc.vo.QuestionThumbsupVO;

public class QthumbDao implements Dao<QuestionThumbsupVO,String>{

	@Autowired
	QthumbMapper mapper;
	
	@Override
	public void insert(QuestionThumbsupVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(QuestionThumbsupVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public QuestionThumbsupVO select(String v) throws Exception {
		return mapper.select(v);
	}

	@Override
	public ArrayList<QuestionThumbsupVO> selectall() throws Exception {
		return mapper.selectall();
	}

}
