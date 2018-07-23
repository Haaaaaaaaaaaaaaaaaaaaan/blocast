package com.bc.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bc.dao.mapper.ClassMapper;
import com.bc.frame.Dao;
import com.bc.vo.ClassVO;
import com.bc.vo.UsersVO;

@Repository("cdao")
public class ClassDao implements Dao<ClassVO,String>{

	@Autowired
	ClassMapper mapper;
	
	@Override
	public void insert(ClassVO t) throws Exception {
		mapper.insert(t);
	}

	@Override
	public void update(ClassVO t) throws Exception {
		mapper.update(t);
	}

	@Override
	public void delete(String v) throws Exception {
		mapper.delete(v);
	}

	@Override
	public ClassVO select(String v) throws Exception {
		return mapper.select(v);
	}

	@Override
	public ArrayList<ClassVO> selectall() throws Exception {
		return mapper.selectall();
	}

	
	@Override
	public void insert(String obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
