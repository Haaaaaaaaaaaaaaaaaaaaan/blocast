package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.frame.UDao;
import com.bc.frame.UService;
import com.bc.vo.UsersVO;

@org.springframework.stereotype.Service("uservice")
public class UsersService implements Service<UsersVO, String>, UService<UsersVO, String>{
	@Resource(name = "udao")
	Dao<UsersVO, String> dao;
	
	@Resource(name = "udao")
	UDao<UsersVO, String> udao;

	@Override
	public void register(UsersVO t) throws Exception {
		dao.insert(t);
	}
	@Override
	public void registerUser(String v, UsersVO t) throws Exception {
		udao.insertUser(v,t);
	}

	@Override
	public void modify(UsersVO t) throws Exception {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(v);
	}

	@Override
	public UsersVO get(String v) throws Exception {
		return dao.select(v);
	}
	
	@Override
	public UsersVO getSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return udao.selectSearch(v);
	}
	

	@Override
	public ArrayList<UsersVO> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectall();
	}
	@Override
	public void register(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
