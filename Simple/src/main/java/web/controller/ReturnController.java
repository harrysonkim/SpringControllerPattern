package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController {

	public static final Logger logger = LoggerFactory.getLogger(ReturnController.class);
	
	@RequestMapping("/return/test1")
	public void returnTest1(Model model) {
		
		System.out.println("/return/test1");

		// viewName : "return/test"
		// View : /WEB-INF/views/return/test.jsp
		
		// 모델값 전달 ( req.setAtrribute() )
		model.addAttribute("title", "void반환 타입");
		model.addAttribute("data", "MODEL DATA");
		
	}

	@RequestMapping("/return/test2")
	public String returnTest2(Model model) {
		
		logger.info("/return/test2 접속!!");

		// 모델값 지정
		model.addAttribute("title", "String반환");
		model.addAttribute("data", "MODEL DATA 2");
		
		// void반환과 같은 방식으로 처리된다
//		return null;
		
		// viewName을 빈문자열로 사용한다
//		return "";
		
		// viewName 직접 지정하기
		return "/return/test1";

	}

	@RequestMapping("/return/test3")
	public ModelAndView returnTest3(ModelAndView mav) {
		
		logger.info("/return/test3 접속!!!");
		
		// null반환, ViewResolver가 동작하지 못한다
//		return null;
		
		//--------------------------------------------
		
//		ModelAndView mav = new ModelAndView();
		
		// 모델값 지정
		mav.addObject("title", "ModelAndView 반환");
		mav.addObject("data", "MODEL DATA 3");
		
		// 뷰네임 지정
//		mav.setViewName(null); // void리턴타입과 동일하게 동작
		mav.setViewName("return/test1");
		
		// ModelAndView객체 반환
		return mav;
		
	}

}
