package interceptor.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import interceptor.dto.User;

@Controller
public class InterceptorController {

//	private static final Logger looger = LoggerFactory.getLogger(interceptorController.class);
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/interceptor/login")
	public void loginForm() {
		logger.info("/interceptor/login [GET]");
	}
	
	@PostMapping("/interceptor/login")
	public String loginProc(User user, HttpSession session) {
		logger.info("/interceptor/login [POST]");
		logger.info("{}", user);
		
		
		if ( "abc".equals( user.getUserId() ) && "123".equals( user.getUserPw() ) ) {
			logger.info("일반 사용자 로그인 성공");
		
			session.setAttribute("login", true); // 로그인 상태
			session.setAttribute("loginid", user.getUserId()); // 로그인 아이디
			session.setAttribute("grade", "g"); // 사용자 등급
			session.setAttribute("nick", "Alice"); // 닉네임
			
		} else if("admin".equals(user.getUserId())) {
			logger.info("관리자 로그인 성공");
			session.setAttribute("login", true); // 로그인 상태
			session.setAttribute("loginid", user.getUserId()); // 로그인 아이디
			session.setAttribute("grade", "a"); // 사용자 등급
			session.setAttribute("nick", "관리자"); // 닉네임

		} else {
			logger.info("로그인 실패");
			
			session.invalidate();
		
		}
		
		return "redirect:./main";
		
	}
	
	@RequestMapping("/interceptor/main")
	public void main() {
		logger.info("/inserceptor/main/");
		
	}

	@RequestMapping("/interceptor/logout")
	public String logout(HttpSession session) {
		logger.info("/interceptor/main/");
		
		session.invalidate();
		return "redirect:./main";
		
	}
	
	@RequestMapping("/interceptor/admin/main")
	public void adminMain() {
		logger.info("/interceptor/admin/main/");
		
	}
	
	@GetMapping("/interceptor/admin/fail")
	public void fail() {
		logger.info("/interceptor/admin/fail");
		
	}
	
	
	
	
	
}
