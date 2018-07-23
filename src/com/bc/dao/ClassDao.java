package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.bc.dao.mapper.ClassMapper;
import com.bc.frame.Dao;
import com.bc.vo.ClassVO;
import com.bc.vo.UsersVO;

public class ClassDao implements Dao<ClassVO,String>{

	@Autowired
	ClassMapper mapper;
	
	@Override
	public void insert(ClassVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(ClassVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public ClassVO select(String v) throws Exception {
		return mapper.select(v);
	}

	@Override
	public ArrayList<ClassVO> selectall() throws Exception {
		return mapper.selectall();
	}

	@Override
	public UsersVO selectSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(String v, ClassVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ClassVO> selectname(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassVO> selectqid(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassVO> selecttid(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassVO> selectnamecont(String obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClassVO> selectauthor(String obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
