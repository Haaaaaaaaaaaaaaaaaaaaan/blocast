package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.QDao;
import com.bc.frame.QService;
import com.bc.frame.Service;
import com.bc.vo.QuestionVO;
import com.bc.vo.UsersVO;

@org.springframework.stereotype.Service("qservice")
public class QuestionService implements Service<QuestionVO, String>, QService<QuestionVO, String>{
	
	@Resource(name = "qdao")
	Dao<QuestionVO, String> dao;
	
	@Resource(name = "qdao")
	QDao<QuestionVO, String> qdao;

	@Override
	public void register(QuestionVO t) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(t);
	}

	@Override
	public void modify(QuestionVO t) throws Exception {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(v);
	}

	@Override
	public QuestionVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(v);
	}

	@Override
	public ArrayList<QuestionVO> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectall();
	}
	@Override
	public ArrayList<QuestionVO> getNameCont(String v) throws Exception {
		// TODO Auto-generated method stub
		return qdao.selectnamecont(v);
	}

	@Override
	public ArrayList<QuestionVO> getAuthor(String v) throws Exception {
		// TODO Auto-generated method stub
		return qdao.selectauthor(v);
	}

	@Override
	public void register(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public UsersVO getSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QuestionVO> getClassid(String v) throws Exception {
		return qdao.selectclass(v);
	}
	
}
