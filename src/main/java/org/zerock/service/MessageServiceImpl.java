package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.MessageVO;

@Service
public class MessageServiceImpl implements MessageService{
	@Inject
	MessageDAO messageDao;
	
	@Inject
	PointDAO pointDao;

	@Transactional
	@Override
	public void addMessage(MessageVO vo) {
		// TODO Auto-generated method stub
		messageDao.create(vo);
		pointDao.updatePoint(vo.getSender(),10);
		
	}

	@Override
	public MessageVO readMessage(String userid, int mno) {
		// TODO Auto-generated method stub
		return null;
	}

}
