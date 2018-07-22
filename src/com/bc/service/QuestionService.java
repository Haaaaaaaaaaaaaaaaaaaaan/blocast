package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.vo.QuestionVO;
import com.bc.vo.UsersVO;

public class QuestionService implements Service<QuestionVO, String>{
	
	@Resource(name = "qdao")
	Dao<QuestionVO, String> qdao;

	@Override
	public void register(QuestionVO t) throws Exception {
		// TODO Auto-generated method stub
		qdao.insert(t);
	}

	@Override
	public void modify(QuestionVO t) throws Exception {
		// TODO Auto-generated method stub
		qdao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		qdao.delete(v);
	}

	@Override
	public QuestionVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return qdao.select(v);
	}

	@Override
	public ArrayList<QuestionVO> get() throws Exception {
		// TODO Auto-generated method stub
		return qdao.selectall();
	}

	@Override
	public UsersVO getSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerUser(String v, QuestionVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	
	
}
