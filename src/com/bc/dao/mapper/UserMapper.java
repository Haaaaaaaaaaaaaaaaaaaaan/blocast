package com.bc.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.bc.vo.UsersVO;

public interface UserMapper {
	
	public void insert(UsersVO obj);
	public void insertUser(@Param("id") String id, UsersVO obj);
	public void delete(String obj);
	public void update(UsersVO obj);
	public UsersVO select(String obj);
	public UsersVO selectSearch(UsersVO obj);
	public ArrayList<UsersVO> selectall();
}
