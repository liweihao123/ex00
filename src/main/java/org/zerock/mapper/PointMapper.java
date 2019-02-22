package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;

public interface PointMapper {
	public void updatePoint(@Param("point") int point, @Param("userid") String userid); //@Param을 사용해서 오는 순서대로 point받고 userid 받고 (맵 대신 사용)

}
