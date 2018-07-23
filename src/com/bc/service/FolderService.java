package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.vo.FolderVO;
import com.bc.vo.UsersVO;

@org.springframework.stereotype.Service("fdservice")
public class FolderService implements Service<FolderVO, String>{
	
	@Resource(name = "fddao")
	Dao<FolderVO, String> fddao;

	@Override
	public void register(FolderVO t) throws Exception {
		// TODO Auto-generated method stub
		fddao.insert(t);
	}

	@Override
	public void modify(FolderVO t) throws Exception {
		// TODO Auto-generated method stub
		fddao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		fddao.delete(v);
	}

	@Override
	public FolderVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return fddao.select(v);
	}

	@Override
	public ArrayList<FolderVO> get() throws Exception {
		// TODO Auto-generated method stub
		return fddao.selectall();
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
