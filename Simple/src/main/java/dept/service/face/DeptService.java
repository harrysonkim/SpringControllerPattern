package dept.service.face;

import java.util.List;

import dept.dto.Dept;

public interface DeptService {

	/**
	 * 전체 부서 목록 조회
	 * 
	 * @return 조회된 전체 부서 목록
	 */
	public List<Dept> list();

}
