package com.bc.dao.mapper;

import java.util.ArrayList;

import com.bc.vo.TagListVO;


public interface TagListMapper {
	public void insert(TagListVO obj);
	public void delete(String obj);
	public void update(TagListVO obj);
	public ArrayList<TagListVO> selectqid(String obj);
	public ArrayList<TagListVO> selecttid(String obj);
	public TagListVO select(String obj);
	public ArrayList<TagListVO> selectall();
}
