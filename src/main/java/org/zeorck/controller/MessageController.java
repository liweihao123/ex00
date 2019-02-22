package org.zeorck.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.MessageVO;
import org.zerock.service.MessageService;



@RestController //responsebody + controller 라는 뜻 -> return 값이 jsp가 아니게 사용 가능하다   
@RequestMapping("/messages/*")
public class MessageController {
	@Inject
	MessageService service;
	
	@RequestMapping(value="/",	method=RequestMethod.POST)	
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){ //@RequestBody JSON 형태를 받을 때 사용
		ResponseEntity<String> entity=null;
		try {
			System.out.println("MessageController :" + vo);
			service.addMessage(vo); //service 객체 위에서 @Inject 하였음

			entity=new ResponseEntity<>("success"	,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage()	,HttpStatus.BAD_REQUEST);
		}
		System.out.println(entity);
		return entity;
	}
}

