package file.service.face;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import file.dto.Filetest;

public interface FileService {

	/**
	 * 전달 파라미터(title), 업로드파일(file)을 처리한다
	 * 
	 * 파일은 upload폴더에 저장한다
	 * DB에 파라미터 정보를 저장한다
	 * 
	 * @param title - 제목
	 * @param file - 파일
	 * @return 
	 */
	public void filesave(String title, MultipartFile file);

	public List<Filetest> getFileList();

	/**
	 * 파일번호를 이용하여 업로드된 파일의 정보를 조회한다
	 * 
	 * @param fileno - 조회할 파일의 번호
	 * @return 조회된 파일의 정보
	 */
	public Filetest getFileList(int fileno);
	
	
	
}
