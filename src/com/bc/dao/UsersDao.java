package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bc.dao.mapper.UserMapper;
import com.bc.frame.Dao;
import com.bc.vo.UsersVO;

@Repository("udao")
public class UsersDao implements Dao<UsersVO,String>{

	@Autowired
	UserMapper mapper;
	
	@Override
	public void insert(UsersVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(UsersVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public UsersVO select(String v) throws Exception {
		return mapper.select(v);
	}
	@Override
	public UsersVO selectSearch(String v) throws Exception {
		return mapper.selectSearch(v);
	}

	@Override
	public ArrayList<UsersVO> selectall() throws Exception {
		return mapper.selectall();
	}

	@Override
	public void insertUser(String v, UsersVO t) throws Exception {
		// TODO Auto-generated method stub
		mapper.insertUser(v,t);
		
	}

	@Override
	public ArrayList<UsersVO> selectname(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UsersVO> selectqid(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UsersVO> selecttid(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UsersVO> selectnamecont(String obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UsersVO> selectauthor(String obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
