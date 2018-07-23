package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bc.dao.mapper.TagMapper;
import com.bc.frame.Dao;
import com.bc.frame.TDao;
import com.bc.vo.TagVO;
import com.bc.vo.UsersVO;

@Repository("tdao")
public class TagDao implements Dao<TagVO,String>, TDao<TagVO, String>{

	@Autowired
	TagMapper mapper;
	
	@Override
	public void insert(TagVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(TagVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public TagVO select(String v) throws Exception {
		return mapper.select(v);
	}
	

	@Override
	public ArrayList<TagVO> selectall() throws Exception {
		return mapper.selectall();
	}


	@Override
	public ArrayList<TagVO> selectname(String v) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectname(v);
	}


	@Override
	public void insert(String obj) throws Exception {
		// TODO Auto-generated method stub
		mapper.insert(obj);
	}

	@Override
	public TagVO selectrecent() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectrecent();
	}
	

}
