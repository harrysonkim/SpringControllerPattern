package file.dao.face;

import java.util.List;

import file.dto.Filetest;

public interface FileDao {

	public int insertFile(Filetest filetest);

	public List<Filetest> selectFileAll();

	/**
	 * 파일번호를 이용하여 업로드 파일의 정보 조회하기
	 * 
	 * @param fileno - 조회할 파일의 번호
	 * @return 조회된 파일의 정보
	 */
	public Filetest selectByFileno(int fileno);
	
}
