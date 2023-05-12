package a.b.c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {
	
	@RequestMapping( value = "/basic/test", method = RequestMethod.GET )
	public void basicMethod () {
		System.out.println("/basic/test [GET]");
		
		
	}

	@RequestMapping( value = "/basic/test", method = RequestMethod.POST )
	public void basicMethod2 () {
		System.out.println("/basic/test [POST]");
		
	}
	
}
