package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.bc.dao.mapper.AnswerMapper;
import com.bc.frame.Dao;
import com.bc.vo.AnswerVO;
import com.bc.vo.UsersVO;

public class AnswerDao implements Dao<AnswerVO,String>{

	@Autowired
	AnswerMapper mapper;
	
	@Override
	public void insert(AnswerVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(AnswerVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public AnswerVO select(String v) throws Exception {
		return mapper.select(v);
	}

	@Override
	public ArrayList<AnswerVO> selectall() throws Exception {
		return mapper.selectall();
	}

	@Override
	public void insert(String obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
