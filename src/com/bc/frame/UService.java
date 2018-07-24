package com.bc.frame;

import com.bc.vo.UsersVO;

public interface UService<T,V> {
	public void registerUser(V v, T t) throws Exception;
	public UsersVO getSearch(UsersVO t) throws Exception;
}
