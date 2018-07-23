package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.vo.ClassVO;
import com.bc.vo.UsersVO;

public class ClassService implements Service<ClassVO, String>{
	
	@Resource(name = "cdao")
	Dao<ClassVO, String> cdao;

	@Override
	public void register(ClassVO t) throws Exception {
		cdao.insert(t);
	}

	@Override
	public void modify(ClassVO t) throws Exception {
		// TODO Auto-generated method stub
		cdao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		cdao.delete(v);
	}

	@Override
	public ClassVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return cdao.select(v);
	}

	@Override
	public ArrayList<ClassVO> get() throws Exception {
		// TODO Auto-generated method stub
		return cdao.selectall();
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
