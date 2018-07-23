package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.vo.QuestionThumbsupVO;
import com.bc.vo.UsersVO;

public class QuestionThumbsupService implements Service<QuestionThumbsupVO, String>{
	
	@Resource(name = "qtdao")
	Dao<QuestionThumbsupVO, String> qtdao;

	@Override
	public void register(QuestionThumbsupVO t) throws Exception {
		// TODO Auto-generated method stub
		qtdao.insert(t);
	}

	@Override
	public void modify(QuestionThumbsupVO t) throws Exception {
		// TODO Auto-generated method stub
		qtdao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		qtdao.delete(v);
	}

	@Override
	public QuestionThumbsupVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return qtdao.select(v);
	}

	@Override
	public ArrayList<QuestionThumbsupVO> get() throws Exception {
		// TODO Auto-generated method stub
		return qtdao.selectall();
	}

	@Override
	public UsersVO getSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
