package web.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogTestController {

	// 로그 객체
	private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

	@RequestMapping( value = "/log/test", method = RequestMethod.GET)
	public void logtest() {
		logger.info("/log/test [GET] 접속");
		//--------------------------------------------------
		System.out.println("=======================");
		logger.trace("트레이스 레벨");
		logger.debug("디버그  레벨");
		logger.info("인포 레벨");
		logger.warn("워닝 레벨");
		logger.error("에러 레벨");
		//--------------------------------------------------
		System.out.println("=======================");

		Object obj = new Object();
		
		// 에러, 로그 메소드에서 객체 타입을 매개 변수로 사용할 수 없다.
//		logger.info(obj);

		logger.info(obj.toString());
	
		//--------------------------------------------------
		System.out.println("=======================");
	
		logger.info("출력 데이터의 {}파라미터");	
		// {} 안에 12345가 대입 (12345를 자동으로 String으로 형 변환)
		logger.info("출력 데이터의 {}파라미터", 12345);	
	
		logger.info("A : {}, B : {}", "A", true);
		
		// 에러, {} 파라미터는 2개까지만 허용
//		logger.info("{}, {}, {}", 1, 2, 3);
	
		// {}파라미터에 객체를 적용하면 .toString()의 결과가 적용된다
		logger.info("{}", obj);

		//--------------------------------------------------
		System.out.println("=======================");
		
		// 여러 개의 {}파라미터를 사용하려면 Object[] 타입을 활용한다
		Object[] data = {"출력", "데이터", "여러 개", "지정하기", 123, new Date()};
	
		logger.info("{},{},{},{},{},{}", data);
	
		//--------------------------------------------------
		System.out.println("=======================");

		int idx = 0;
		logger.info("#{}. , 에러 메시지 출력", idx++);
		logger.info("#{}. 주석대신 사용하기 좋음", idx++);
		logger.info("#{}. 로그레벨에 맞게 콘솔에 출력", idx++);
		logger.info("#{}. 개발할 때 idx변수를 활용하여", idx++);
		logger.info("#{}. 순서에 맞는 로그를 남길 수 있음", idx++);
		logger.info("#{}. ", idx++);
	
	}
	
}
