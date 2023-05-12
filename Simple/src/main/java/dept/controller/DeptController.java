package dept.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dept.dto.Dept;
import dept.service.face.DeptService;

@Controller
public class DeptController {

	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired private DeptService deptSerivce;
	
	@RequestMapping("/dept/list")
	public void list(Model model) {
		logger.info("/dept/list [GET]");
		
		// 전체 부서 목록 조회
		List<Dept> list = deptSerivce.list();
		
		model.addAttribute("list", list);
	}
}
