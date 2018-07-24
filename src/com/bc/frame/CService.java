package com.bc.frame;

import com.bc.vo.ClassVO;

public interface CService<T,V> {
	public ClassVO getname(V v) throws Exception;
}
