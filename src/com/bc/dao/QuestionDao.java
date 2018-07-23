package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bc.dao.mapper.QuestionMapper;
import com.bc.frame.Dao;
import com.bc.frame.QDao;
import com.bc.vo.QuestionVO;
import com.bc.vo.UsersVO;

@Repository("qdao")
public class QuestionDao implements Dao<QuestionVO,String>, QDao<QuestionVO,String>{

	@Autowired
	QuestionMapper mapper;
	
	@Override
	public void insert(QuestionVO t) throws Exception {
		System.out.println("before dao QVO t :" + t);
		mapper.insert(t);
	}

	@Override
	public void update(QuestionVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public QuestionVO select(String v) throws Exception {
		return mapper.select(v);
	}

	@Override
	public ArrayList<QuestionVO> selectall() throws Exception {
		return mapper.selectall();
	}

	@Override
	public ArrayList<QuestionVO> selectnamecont(String obj) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectnamecont(obj);
	}

	@Override
	public ArrayList<QuestionVO> selectauthor(String obj) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectauthor(obj);
	}

	@Override
	public void insert(String obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<QuestionVO> selectclass(String obj) throws Exception {
		return mapper.selectclass(obj);
	}
	@Override
	public QuestionVO selectrecent() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectrecent();
	}

}
