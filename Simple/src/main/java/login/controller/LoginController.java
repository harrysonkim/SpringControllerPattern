package login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dept.controller.DeptController;
import login.dto.Login;
import login.service.face.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired private LoginService loginService;
	
	@RequestMapping("/main")
	public void main() {
		logger.info("/login/main");
		
	}
	
	@RequestMapping("/join")
	public void join() {
		logger.info("/login/join");
		
		
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinProc(Login login, HttpSession session) {
		logger.info("/login/join [POST]");
		
		loginService.addJoin(login);
		
		return "/login/main";
	}

	@RequestMapping("/login")
	public void login() {
		logger.info("/login/login");
		
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProc(Login login, HttpSession session) {
		logger.info("/login/login [POST]");
	
		Login user = new Login();
		user = loginService.isLogin(login);
	
		if(user != null) {
			
			session.setAttribute("login", true);
			session.setAttribute("user", user);
			
			return "/login/main";
			
		} else {
			
			return "/login/login";
		}
		
	}
	
	@RequestMapping("/mypage")
	public void mypage() {
		logger.info("/login/mypage");
	
		
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("/login/logout");

		session.invalidate();
		
		return "redirect:./main";
	}
	


}
