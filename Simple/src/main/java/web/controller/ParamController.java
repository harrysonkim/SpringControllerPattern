package web.controller;
//Spring에서는 파라미터를 보내고 받는 것을 어떻게 하는지 알아보기로함!

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import web.dto.User;

@Controller
public class ParamController {

	private static final Logger logger = LoggerFactory.getLogger(ParamController.class);

	@RequestMapping(value = "/param/requestParam", method = RequestMethod.GET)
	public String paramForm() {
		logger.info("/param/requestParam [GET]");

//		return null;
		return "param/paramForm";
	}

	@RequestMapping(value = "/param/requestParam", method = RequestMethod.POST)
	public void paramResult(

	// 기본 전달 파라미터 처리 변수
//			String username ,
//			String userage
//			int userage //알아서 파싱해준다, 나이를 문자로 작성하면 int로 파싱하려는 순간에 오류를 보여준다 
	// WARN :
	// org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver -
	// Resolved
	// [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException:
	// Failed to convert value of type 'java.lang.String' to required type 'int';
	// nested exception is
	// java.lang.NumberFormatException: For input string: "bb"]
	// 문자를 숫자로 파싱하려고 하기에 문제가 생겼다 라는 설명..

	// input의 name값을 매개변수의 이름과 동일하지 않게 사용한다면 발생하는 오류
	// java.lang.IllegalStateException: Optional int parameter 'userage' is present
	// but cannot be translated
	// into a null value due to being declared as a primitive type.
	// Consider declaring it as object wrapper for the corresponding primitive type.
	// 전달한 정보가 null로 전달되는데 int형으로 변환(파싱)하려고 했기 떄문에 에러가 발생했다는 것임
	// 그렇기에 int형이 아니라 String으로 변경해주면 에러는 발생하지 않으나 null이 발생하게 된다
//			String userage

	// String username = req.getParameter("aaaaa"); 의 어노테이션화
	// 이름이 맞지 않아도 사용할수 있게 해주는 어노테이션이 있다
	// name속성은 파싱할 전달 파라미터의 이름을 지정하는 속성이다
	// value 속성은 name속성의 별칭이다
//			@RequestParam(value = "aaaaaa") String username, //@AliasFor(value="name") - name을 value로 쓸수 있게 해줌
//			@RequestParam(name = "bbbbbb") String userage //원래는 name을 사용하는게 맞음

			// 왜 value를 별칭으로 했는가..? 어노테이션은 value를 생략할수 있게 해놨기 떄문에
			// 단독으로 value만 사용한다면 생략이 가능하다
			// value속성은 단독으로 쓰일 때 생략할 수 있다
			@RequestParam("aaaaaa") String username, // @AliasFor(value="name")으로 해뒀기 때문에 문제가 발생하지 않음
			@RequestParam("bbbbbb") String userage // 그래서 이렇게만 사용해도 괜찮음

	) {
		logger.info("/param/requestParam [POST]");

		// 파라미터를 꺼내는 방식은 매개변수에 해당 input태그의 name속성의 String값과 동일한
		// 이름으로 String변수를 선언 해서 넣어주면 내부에서 자동으로 가져와진다...
		// 전달 파라미터와 동일한 이름을 쓴다고 보면 됨

		logger.info("username: " + username);
		logger.info("userage: " + userage);
		logger.info("username: {}, userage: {} ", username, userage);
		// INFO : web.controller.ParamController - username: ãã, userage: 12 한글을
		// 넣었을때 한글이 깨짐
		// 필터로 해결하자
		// web.xml에 필터를 설정할수 있음

		/*
		 * 
		 * <filter> <filter-name>encodingFilter</filter-name>
		 * <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-
		 * class> <init-param> <param-name>encoding</param-name>
		 * <param-value>UFT-8</param-value> </init-param> </filter> <filter-mapping>
		 * <filter-name>encodingFilter</filter-name> <url-pattern>/*</url-pattern>
		 * </filter-mapping>
		 * 
		 */
	}

	@RequestMapping("/param/test")
	public void paramTest(

//			String data

//			@RequestParam String data //data라는 항목이 있기 떄문에 빈칸으로 보내면 null 이 아니라 빈문자열이 온다
	// 그러나 data가 아닌 다른것으로 보내면 null값이 오게 된다..변경해서 넣어보면
	// WARN :
	// org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver -
	// Resolved
	// [org.springframework.web.bind.MissingServletRequestParameterException:
	// Required request parameter 'data' for method parameter type String is not
	// present]

	// 어노테이션으로 데이터로 받으려고 data라고 받으려고 한다고 했으면서 안보냈다 라는 오류임
	// 서버쪽에서 필요하다고 했는데 클라이언트에서 안보냈으니 클라이언트 문제이다 라고 하는 것임

	// 어노테이션을 주석으로 하고 다시 String data를 살린후에 쿼리스트링을 data=가 아닌 것으로 보내면
	// INFO : web.controller.ParamController - data: null null이 나오는 것을 볼수 있음..

	// 이러한 @RequestParam 어노테이션에 넣을수 있는 속성을 보자

	// data전달 파라미터 필수 O
//			@RequestParam(required = true) String data // = @RequestParam String data

			// data전달 파라미터 필수 X
			@RequestParam(required = false) String data // String data

	) {
		logger.info("/param/test 접속");
		logger.info("data: {}", data); // url에 쿼리스트링을 넣어서 값을 출력해보자
		// http://localhost:8888/param/test?data=전송하고자 하는 값
	}

	@RequestMapping(value = "/board/list2", method = RequestMethod.GET)
	public void boardlist(

//			String curPage

//			int curPage // null 또는 "" 이 전달되면 에러 발생

//			@RequestParam(required = true) int curPage

			@RequestParam(defaultValue = "0") int curPage

	) {
		logger.info("/board/list2 [GET]");

		logger.info("curPage : {}", curPage);
	}

	@RequestMapping("/value/test")
	public void valueTest(
			
			String data,
			@RequestParam(name = "data") String d1,
			@RequestParam(value = "data") String d2,
			@RequestParam("data") String d3
			
			) {
		logger.info("/value/test");

		logger.info("data : {}", data);
		logger.info("d1 : {}", d1);
		logger.info("d2 : {}", d2);
		logger.info("d3 : {}", d3);

		
	}
	
///////////////////////////////////////////////////////////////////////
// method가 정의되어 있는 어노테이션	
///////////////////////////////////////////////////////////////////////
	
//	@RequestMapping(value = "/param/map", method = RequestMethod.GET)
	@GetMapping("/param/map")
	public void paramMapForm() {
		logger.info("/param/map [GET]");
	}

//	@RequestMapping(value = "/param/map", method = RequestMethod.POST)
	@PostMapping("/param/map")
	public String paramMapResult(
			
			// 전달 파라미터를추출하지 않느다
			// 일반 해시맵 객체를 생성
			HashMap<String, String> map,

			// 전달 파라미터를 추출한다 (@RequestParam 필요)
			@RequestParam
			HashMap<String, String> paramMap,
			
			Model model
			
			) {
		logger.info("/param/map [POST]");
		
		logger.info("{}", map);
		logger.info("{}", paramMap);
		
		// 모델값 전달 - 객체 자체를 모델값으로 전달
		model.addAttribute("m", paramMap);

		// 모델값 전달 - 맵 객체 내부의 키 = 값 쌍을 각각의 모델값으로 분리해서 전달한다
		model.addAllAttributes(paramMap);
		
		return "param/mapResult";
	}
	
	@GetMapping("/param/dto")
	public void paramDtoForm() {}

	@PostMapping("/param/dto")
	public String paramDtoResult(
			
			// @ModelAtrribute의 name속성을 이용하여
			// 모델값 이름을 지정할 수 있다
			// ** 전달파라미터 name과는 상관없다
			
			User user // 커맨드 객체, Commend Object
			, @ModelAttribute User user2
			, @ModelAttribute("u3") User user3
			, Model model
			
			) {
		
		logger.info("/param/dto [POST]");

		logger.info("{}", user);
		logger.info("{}", user2);
		
		model.addAttribute("u2", user2);
		
		return "/param/dtoResult";
	}

	///////////////////////////////////////////////////
	// Controller Method의 매개변수 종류별 쓰는 방법 //
	///////////////////////////////////////////////////
	@RequestMapping("/param/sample")
	public void paramTest(
			
			HttpServletRequest req,
			HttpServletResponse resp,
			
			Writer out,
			Reader in,

			OutputStream outStream,
			InputStream inStream,
			
			HttpSession session,

			// 세션 컨텍스트 정보를 추출하여 매개변수에 대입한다
			@SessionAttribute("login") boolean login,
			@SessionAttribute("loginid") String loginid

			) {

//////////// 쓸수 있지만.. 굳이 쓸 필요 없다 ///////////////////
//		req.setCharacterEncoding("UTF-8");
//		req.getParameter("name");
//		req.getRequestDispatcher("JSP").forward(req, pesp);
//=============================================================		
//		resp.sendRedirect("URL");
//		Writer o = resp.getWriter();
//=============================================================		
//		resp.setContentType("text/html;charset=utf-8");
//		out.append("HTML");
////////////////////////////////////////////////////////////////
		session.setAttribute("name", "value");
	
		session.getAttribute("name");
		
	}
	
	
	
	
	
}
