package org.zerock.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.MessageVO;
import org.zerock.mapper.MessageMapper;
import org.zerock.mapper.PointMapper;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageMapper mapper;
	@Inject
	private PointMapper pmapper;

	@Transactional
	@Override
	public void addMessage(MessageVO vo) {
		// TODO Auto-generated method stub
		mapper.create(vo);
//		pmapper.updatePoint(vo.getSender(),10);
		pmapper.updatePoint(10,vo.getSender()); //map 안담고 xml 역활에서 @Param으로 받음
		
	}

	@Override
	public MessageVO readMessage(String userid, int mno) {
		// TODO Auto-generated method stub
		return null;
	}

}
