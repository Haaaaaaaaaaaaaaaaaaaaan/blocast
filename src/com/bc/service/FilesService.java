package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.vo.FilesVO;
import com.bc.vo.UsersVO;

@org.springframework.stereotype.Service("fservice")
public class FilesService implements Service<FilesVO, String>{
	
	@Resource(name = "fdao")
	Dao<FilesVO, String> fdao;

	@Override
	public void register(FilesVO t) throws Exception {
		// TODO Auto-generated method stub
		fdao.insert(t);
	}

	@Override
	public void modify(FilesVO t) throws Exception {
		// TODO Auto-generated method stub
		fdao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		// TODO Auto-generated method stub
		fdao.delete(v);
	}

	@Override
	public FilesVO get(String v) throws Exception {
		// TODO Auto-generated method stub
		return fdao.select(v);
	}

	@Override
	public ArrayList<FilesVO> get() throws Exception {
		// TODO Auto-generated method stub
		return fdao.selectall();
	}
	
	@Override
	public void register(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
