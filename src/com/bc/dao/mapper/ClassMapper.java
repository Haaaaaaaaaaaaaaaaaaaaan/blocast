package com.bc.dao.mapper;

import java.util.ArrayList;

import com.bc.vo.ClassVO;

public interface ClassMapper {
	public void insert(ClassVO obj);
	public void delete(String obj);
	public void update(ClassVO obj);
	public ClassVO select(String obj);
	public ClassVO selectname(String obj);
	public ArrayList<ClassVO> selectall();
}
