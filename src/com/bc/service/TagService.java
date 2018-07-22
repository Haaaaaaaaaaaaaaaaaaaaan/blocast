package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.vo.TagVO;
import com.bc.vo.UsersVO;

public class TagService implements Service<TagVO,String>{

	@Resource(name="tdao")
	Dao<TagVO,String> tdao;
	@Override
	public void register(TagVO t) throws Exception {
		tdao.insert(t);
	}

	@Override
	public void modify(TagVO t) throws Exception {
		tdao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		tdao.delete(v);
	}

	@Override
	public TagVO get(String v) throws Exception {
		return tdao.select(v);
	}

	@Override
	public ArrayList<TagVO> get() throws Exception {
		return tdao.selectall();
	}

	@Override
	public UsersVO getSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerUser(String v, TagVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
