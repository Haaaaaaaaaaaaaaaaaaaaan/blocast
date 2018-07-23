package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.frame.TDao;
import com.bc.frame.TService;
import com.bc.vo.TagVO;
import com.bc.vo.UsersVO;

@org.springframework.stereotype.Service("tservice")
public class TagService implements Service<TagVO,String>, TService<TagVO,String>{

	@Resource(name="tdao")
	Dao<TagVO,String> dao;
	
	@Resource(name="tdao")
	TDao<TagVO,String> tdao;
	
	@Override
	public void register(String v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(TagVO t) throws Exception {
		dao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		dao.delete(v);
	}

	@Override
	public TagVO get(String v) throws Exception {
		return dao.select(v);
	}

	@Override
	public ArrayList<TagVO> get() throws Exception {
		return dao.selectall();
	}

	@Override
	public UsersVO getSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<TagVO> getName(String v) throws Exception {
		// TODO Auto-generated method stub
		return tdao.selectname(v);
	}

	@Override
	public void register(TagVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TagVO getRecent() throws Exception {
		// TODO Auto-generated method stub
		return tdao.selectrecent();
	}

}
