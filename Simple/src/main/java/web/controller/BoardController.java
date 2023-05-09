package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	@RequestMapping( value = "/board/list", method = RequestMethod.GET )
	public void list() {
		System.out.println("/board/list 접속! [GET]");
	}
	
	@RequestMapping( value = "/board/list", method = RequestMethod.POST )
	public void list_post() {
		System.out.println("/board/list 접속! [POST]");
	}

	// method속성을 지정하지 않으면 모든 요청메소드 방식을 처리할 수 있다
	// 	같은 URL Pattern으로 지정된 메소드 처리방식이 있으면
	// 	해당 방식을 제외한 나머지 요청 메소드를 처리한다
	@RequestMapping( value = "/board/write" )
	public void write() {
		System.out.println("/board/write 접속! [X]");
	}

	@RequestMapping( value = "/board/write", method = RequestMethod.POST )
	public void write_post() {
		System.out.println("/board/write 접속! [POST]");
	}
	
	// value="속성값" 형태의 속성을 단독으로 사용하는 경우라면
	// value=를 todfirgkrh "속성값"만 적용할 수 있다
	// ** 이때 다른 속성은 설정할 수 없다
	@RequestMapping("/board/update")
	public void update() {
		System.out.println("/board/update 접속! [X]");
	}

	@RequestMapping("/board/delete")
	public void delete() {
		System.out.println("/board/delete 접속! [X]");
	}
	
	
}
