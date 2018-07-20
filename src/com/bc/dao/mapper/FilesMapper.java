package com.bc.dao.mapper;

import java.util.ArrayList;

import com.bc.vo.FilesVO;


public interface FilesMapper {
	public void insert(FilesVO obj);
	public void delete(String obj);
	public void update(FilesVO obj);
	public FilesVO select(String obj);
	public ArrayList<FilesVO> selectall();
}
