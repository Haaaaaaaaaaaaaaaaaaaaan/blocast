package com.bc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.bc.frame.Dao;
import com.bc.frame.Service;
import com.bc.vo.TagListVO;
import com.bc.vo.UsersVO;

public class TagListService implements Service<TagListVO,String>{

	@Resource(name="tldao")
	Dao<TagListVO,String> tldao;
	
	@Override
	public void register(TagListVO t) throws Exception {
		tldao.insert(t);
	}

	@Override
	public void modify(TagListVO t) throws Exception {
		tldao.update(t);
	}

	@Override
	public void remove(String v) throws Exception {
		tldao.delete(v);
	}

	@Override
	public TagListVO get(String v) throws Exception {
		return tldao.select(v);
	}

	@Override
	public ArrayList<TagListVO> get() throws Exception {
		return tldao.selectall();
	}

	@Override
	public UsersVO getSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerUser(String v, TagListVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TagListVO> getName(String v) throws Exception {
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
	public ArrayList<TagListVO> getNameCont(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TagListVO> getAuthor(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
