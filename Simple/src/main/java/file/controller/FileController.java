package file.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import file.dto.Filetest;
import file.service.face.FileService;

@Controller
@RequestMapping("/file")
public class FileController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired FileService fileService;
	
	@GetMapping("/fileup")
	public void fileForm() {
		logger.info("/file/fileup [GET]");
	}

//	@PostMapping("/fileup")
//	public void fileProc(String title, MultipartFile file) {
//		logger.info("/file/fileup [POST]");
//
//		logger.info("{}", title);
//		logger.info("{}", file);
//	}

//	@PostMapping("/fileup")
//	public void fileProc(FileParam data) {
//		logger.info("/file/fileup [POST]");
//		
//		logger.info("{}", data);
//	}
	
	@PostMapping("/fileup")
	public String fileProc(
			
			String title,
			@RequestParam("title") String t,
			
			MultipartFile file,
			@RequestParam("file") MultipartFile f,
			
			List<MultipartFile> data,
			List<MultipartFile> dataMul,
			@RequestParam("dataMul") MultipartFile d
			
			) {
		logger.info("/file/fileup [POST]");

		fileService.filesave(title, file);
		
//		logger.info("{}", title);
//		logger.info("{}", t);
//		logger.info("{}", file);
//		logger.info("{}", f);
		logger.info("data : {}", data);
		logger.info("dataMul : {}", dataMul);
		logger.info("d : {}", d);
		
		return "redirect:/file/list";
		
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		logger.info("/file/list [GET]");
		
		List<Filetest> fileList = new ArrayList<>();
		fileList = fileService.getFileList();

		int idx = 1;
		
		logger.info("fileList[{}] : {}", idx++, fileList);
		
		model.addAttribute("fileList", fileList);
	}

	@GetMapping("/download")
	public String download(int fileno, Model model) {
		logger.info("/file/download [GET]");
		logger.info("fileno : {}", fileno);
		
		// 파일번호에 해당하는 파일 정보 가져오기
		Filetest file = fileService.getFileList(fileno);
		logger.info("file : {}", file);
		
		// 다운로드 시켜줄(응답)파일의 정보를 모델 값으로 뷰에 전달
		model.addAttribute("downFile", file);
		
		
		
		
		
		
		//viewName을 "down"으로 지정하여 리턴한다
		// BeanNameViewResolver가 동작한다
		// DownloadView 빈을 View로 사용하게 된다
		
		
		return "down";
	}
	
	
	
	
}
