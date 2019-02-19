package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TImeMapper {
	@Select("Select sysdate from dual")
	public String getTime();

}
