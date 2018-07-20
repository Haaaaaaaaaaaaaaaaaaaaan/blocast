package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.bc.dao.mapper.TagMapper;
import com.bc.frame.Dao;
import com.bc.vo.TagVO;

public class TagDao implements Dao<TagVO,String>{

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
	

}
