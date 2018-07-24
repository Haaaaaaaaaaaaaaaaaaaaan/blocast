package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.CDao;
import com.bc.frame.CService;
import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.vo.ClassVO;
import com.bc.vo.UsersVO;

@org.springframework.stereotype.Service("cservice")
public class ClassService implements Service<ClassVO, String>, CService<ClassVO, String>{
	
	@Resource(name = "cdao")
	Dao<ClassVO, String> cdao;
	
	@Resource(name = "cdao")
	CDao<ClassVO, String> cdao2;

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
	public void register(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClassVO getname(String v) throws Exception {
		// TODO Auto-generated method stub
		return cdao2.selectname(v);
	}
	
}
