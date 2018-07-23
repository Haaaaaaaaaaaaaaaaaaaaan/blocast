package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.bc.dao.mapper.TagListMapper;
import com.bc.frame.Dao;
import com.bc.vo.TagListVO;
import com.bc.vo.UsersVO;

public class TagListDao implements Dao<TagListVO,String>{

	@Autowired
	TagListMapper mapper;
	
	@Override
	public void insert(TagListVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(TagListVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public TagListVO select(String v) throws Exception {
		return mapper.select(v);
	}

	@Override
	public ArrayList<TagListVO> selectall() throws Exception {
		return mapper.selectall();
	}

	@Override
	public UsersVO selectSearch(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(String v, TagListVO t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TagListVO> selectname(String v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TagListVO> selectqid(String obj) {
		// TODO Auto-generated method stub
		return mapper.selectqid(obj);
	}

	@Override
	public ArrayList<TagListVO> selecttid(String obj) {
		// TODO Auto-generated method stub
		return mapper.selecttid(obj);
	}

	@Override
	public ArrayList<TagListVO> selectnamecont(String obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TagListVO> selectauthor(String obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
