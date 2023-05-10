package dept.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dept.dao.face.DeptDao;
import dept.dto.Dept;
import dept.service.face.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

//	private static final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);
	private static final Logger logger = LoggerFactory.getLogger(DeptService.class);

	@Autowired private DeptDao deptDao;
	
	@Override
	public List<Dept> list() {
		logger.info("list()");
		
		List<Dept> list = deptDao.selectAll();
		
		return list;
	}

}
