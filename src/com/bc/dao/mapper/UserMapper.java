package com.bc.dao.mapper;

import java.util.ArrayList;
import com.bc.vo.UsersVO;

public interface UserMapper {
	public void insert(UsersVO obj);
	public void delete(String obj);
	public void update(UsersVO obj);
	public UsersVO select(String obj);
	public ArrayList<UsersVO> selectall();
}
