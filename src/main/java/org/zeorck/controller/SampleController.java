package org.zeorck.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;



@Controller
@RequestMapping("/sample/*") //sample을 타고 오는 모든것
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class); //lombok log 오류가 계속나서 homeController에서 가져와서 이름만 바꿈
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		logger.info(""+dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(String name, int age) {
		logger.info("name:" + name);
		logger.info("age:" + age);
		return "ex02";
	}
	
	@GetMapping("/ex021")
	public String ex021(@RequestParam("name") String names, int age) { //여기 받는 변수값이 보내 올떄 이름이랑 일치해야만 자동으로 맵핑함 그래서 다르게 받을려면 @RequestParam을 써줘야함
		logger.info("name:" + names);
		logger.info("age:" + age);
		return "ex021";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(String[] ids) { //String[] ids ==> ArrayList<String> ids 로 받을 수도 있다 
		logger.info("ids:" + ids);
		for(int i=0;i<ids.length;i++) {
			logger.info("ids" + i + ":" + ids[i]);
		}
		return "ex02List";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page) { //dto는 있는 객체라서 여기서 "Model model" 받아서 model.addAttribute("dto",dto)을 안써도 jsp파일까지 값이 넘어간다 부를땐 첫글자를 소문자로 부르면됨. page는 안만들어서 안넘어가진다(만들면 넘길 수 있음)
		logger.info(""+dto); 			//"" 제일 앞에 찍어야만 먹힘 이유는 모르겠지만
		logger.info("page:" + page);
		return "ex04";
	}
	
	@GetMapping("/ex041")
	public String ex041(SampleDTO dto, @ModelAttribute("page")int page) { //ex04와 연결로 이렇게 그냥 바로 @ModelAttibute해서 "page"에 담을 수 있음
		logger.info(""+dto); 			
		logger.info("page:" + page);
		return "ex04";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {  //@ResponseBody를 적어 줘야함 return에 넘기고싶은 객체(JSON)를 적을 수 있다(JACKSON databind를 maven repository에서 가져와서 추가하고 해야 JSON처리 가능)
		SampleDTO dto = new SampleDTO();
		dto.setAge(20);
		dto.setName("홍길동");
		return dto; 		//return dto; 이렇게 return하게 되면 dto.jsp로 가기때문에 오류남 그래서 위에 @ResponseBody 적음
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {  //ResponseEntity 추가적인 정보를 더 줄 때 사용한다.. OK 등 같은 값을 웹에서 "검사"해서 network 들어가면 header에 정보 표시됨
		logger.info("/ex07........");
		//{"name":"홍길동"}
		String msg = "{\"name\":\"홍길동\"}"; // "" 를 쓸때 \를 하고 써줘야 "자체를 출력 가능
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type","application/json;charset=UTF-8"); //한글 encoding 
		return new ResponseEntity<>(msg,header,HttpStatus.OK); 		//return dto; 이렇게 return하게 되면 dto.jsp로 가기때문에 오류남 그래서 위에 @ResponseBody 적음
	}

}
