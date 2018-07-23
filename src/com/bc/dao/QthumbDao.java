package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.bc.dao.mapper.QthumbMapper;
import com.bc.frame.Dao;
import com.bc.vo.QuestionThumbsupVO;
import com.bc.vo.UsersVO;

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

	@Override
	public UsersVO selectSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(String v, QuestionThumbsupVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<QuestionThumbsupVO> selectname(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QuestionThumbsupVO> selectqid(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QuestionThumbsupVO> selecttid(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QuestionThumbsupVO> selectnamecont(String obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QuestionThumbsupVO> selectauthor(String obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
