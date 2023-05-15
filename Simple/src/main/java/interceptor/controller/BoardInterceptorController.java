package interceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardInterceptorController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/interceptor/board/list")
	public void list() {
		logger.info("/interceptor/board/list [GET]");

		
	}

	@GetMapping("/interceptor/board/write")
	public void write() {
		logger.info("/interceptor/board/write [GET]");

		
	}

	@PostMapping("/interceptor/board/write")
	public String writeProc() {
		logger.info("/interceptor/board/write [POST]");

		return "redirect:./list";
	}
	
	@GetMapping("/interceptor/board/noLogin")
	public void noLogin() {
		logger.info("/interceptor/board/noLogin [GET]");
		
	}
	
	
}
