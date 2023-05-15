package file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/fileup")
	public void fileForm() {
		logger.info("/file/fileup [GET]");
	}

	@PostMapping("/fileup")
	public void fileProc(String title, MultipartFile file) {
		logger.info("/file/fileup [POST]");
		logger.info("{}", title);
		logger.info("{}", file);

		
		
	}
	
}
