package com.bc.dao.mapper;

import java.util.ArrayList;

import com.bc.vo.FolderVO;

public interface FolderMapper {
	public void insert(FolderVO obj);
	public void delete(String obj);
	public void update(FolderVO obj);
	public FolderVO select(String obj);
	public ArrayList<FolderVO> selectall();
}
