package org.zerock.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void updatePoint(String userid, int point) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>(); //HashMap이 Map의 상속받은 하위기 때문에 이렇게 사용 해도 된다 ^ㅗ^&
		map.put("userid",userid);
		map.put("point",point);
		System.out.println("map:" + map);
		sqlSession.update("updatePoint",map);
	}

}
