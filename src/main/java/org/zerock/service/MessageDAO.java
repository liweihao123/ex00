package org.zerock.service;

import org.zerock.domain.MessageVO;

public interface MessageDAO {
	public void create(MessageVO vo);
	public MessageVO readMessage(int mno);
	public void updateState(int mno);

}
