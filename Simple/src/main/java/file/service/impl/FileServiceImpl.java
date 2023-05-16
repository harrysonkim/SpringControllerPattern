package file.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import file.dao.face.FileDao;
import file.dto.Filetest;
import file.service.face.FileService;

@Service
public class FileServiceImpl implements FileService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired ServletContext context;
	@Autowired FileDao fileDao;

	@Override
	public void filesave(String title, MultipartFile file) {

		if (file.getSize() <= 0) {
			logger.info("파일의 크기가 0이다, 처리 중단!");

			// filesave()메소드 중단
			return;
		}

		// 파일이 저장될 경로 - RealPath
		String storedPath = context.getRealPath("upload");
		logger.info("storedPath : {} ", storedPath);

		// upload폴더가 존재하지 않으면 생성한다
		File storedFolder = new File(storedPath);
		storedFolder.mkdir();

		File dest = null;
		String storedName = null;
		do {
			// 저장할 파일 이름 생성하기
			storedName = file.getOriginalFilename();// 원본파일명
			storedName += UUID.randomUUID().toString().split("-")[0];// UUID추가
			logger.info("storedName : {}", storedName);

			// 실제 저장될 파일 객체
			dest = new File(storedFolder, storedName);

		} while ( dest.exists() );

		try {
			// 업로드된 파일을 upload폴더에 저장ㅎ가ㅣ
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//---------------------------------------
		
		//DB에 기록할 정보 객체
		Filetest filetest = new Filetest();
		
		filetest.setTitle(title);
		filetest.setOrigin_name(file.getOriginalFilename());
		filetest.setStored_name(storedName);
		logger.info("filetest : {}", filetest);
		
		int res = fileDao.insertFile(filetest);
		
		
		if(res > 0) {
			logger.info(" 업로드 성공! res : {} ", res);
			
		} else {
			logger.info(" 업로드 실패! res : {} ", res);
		}

	}

	@Override
	public List<Filetest> getFileList() {
		
		List<Filetest> fileList = new ArrayList<>();

		fileList = fileDao.selectFileAll();
		
		
		return fileList;
		
	}
	
	@Override
	public Filetest getFileList(int fileno) {

		
		return fileDao.selectByFileno(fileno);
	}

}
