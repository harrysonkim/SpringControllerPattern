package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@GetMapping("/forward")
	public String forwardpage() {
		logger.info("/page/forward/ ");
		
		// 전달된 "viewName"을 이용하여 InternalResourceViewResolver가 JSP로 포워드 한다
//		return "viewName";
//		return "forward:/WEB-INF/views/page/forward.jsp";
		
		// forward: 뒤에 붙인 URL 경로의 자원(컨트롤러)으로
		// InternalResourceViewResolver가 포워드한다
		return "forward:/param/dto";

	}

	@GetMapping("/redirect")
	public String redirectpage() {
		logger.info("/page/redirect ");
		
		return "redirect:/param/map";
	}

	@GetMapping("/redirectMav")
	public ModelAndView redirectPageMav( ModelAndView mav) {
		logger.info("/page/redirectMav ");
		
//		mav.setViewName("viewName"); // JSP로 forward
//		mav.setViewName("forward:/param/dto"); // URL로 forword
		mav.setViewName("redirect:/param/map"); // URL로 redirect
		
		return mav;
	}
}
