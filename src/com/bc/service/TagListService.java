package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.frame.TlDao;
import com.bc.frame.TlService;
import com.bc.vo.TagListVO;
import com.bc.vo.UsersVO;

public class TagListService implements Service<TagListVO,String>, TlService<TagListVO,String>{

	@Resource(name="dao")
	Dao<TagListVO,String> dao;
	
	@Resource(name="tldao")
	TlDao<TagListVO,String> tldao;
	
	@Override
	public void register(TagListVO t) throws Exception {
		dao.insert(t);
	}

	@Override
	public void modify(TagListVO t) throws Exception {
		dao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		dao.delete(v);
	}

	@Override
	public TagListVO get(String v) throws Exception {
		return dao.select(v);
	}

	@Override
	public ArrayList<TagListVO> get() throws Exception {
		return dao.selectall();
	}

	@Override
	public UsersVO getSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<TagListVO> getQid(String v) throws Exception {
		// TODO Auto-generated method stub
		return tldao.selectqid(v);
	}

	@Override
	public ArrayList<TagListVO> getTid(String v) throws Exception {
		// TODO Auto-generated method stub
		return tldao.selecttid(v);
	}

	@Override
	public void register(String v) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
