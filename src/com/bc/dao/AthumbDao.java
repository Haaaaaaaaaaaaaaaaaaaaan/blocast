package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.bc.dao.mapper.AthumbMapper;
import com.bc.frame.Dao;
import com.bc.vo.AnswerThumbsupVO;

public class AthumbDao implements Dao<AnswerThumbsupVO,String>{

	@Autowired
	AthumbMapper mapper;
	
	@Override
	public void insert(AnswerThumbsupVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(AnswerThumbsupVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public AnswerThumbsupVO select(String v) throws Exception {
		return mapper.select(v);
	}

	@Override
	public ArrayList<AnswerThumbsupVO> selectall() throws Exception {
		return mapper.selectall();
	}

}
